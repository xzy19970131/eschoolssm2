package com.oracle.eschoolssm.control;


import com.oracle.eschoolssm.model.bean.Admin;
import com.oracle.eschoolssm.model.bean.User;
import com.oracle.eschoolssm.model.dao.AdminDAO;


import com.oracle.eschoolssm.model.dao.UserDAO;

import com.oracle.eschoolssm.service.AdminService;

import com.oracle.eschoolssm.service.UserService;
import org.apache.ibatis.session.SqlSession;
import org.apache.poi.util.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;


@Controller
public class AdminController {
    private AdminService adminService;

    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }


    /**
     * 管理员登录
     * @param admin
     * @return
     */
    @RequestMapping("/login")
    public String  processLogin(@ModelAttribute("admin") Admin admin){
        System.out.println("进入管理员登录");
        Admin u=adminService.processLogin(admin);
        if(u==null)
        {
            return "login";
        }else
        {
            return "admin_add_user";
        }

    }

    /**
     * 添加管理员
     * @param admin
     * @return
     */
    @RequestMapping("/addAdmin")
    public String  addAdmin(@ModelAttribute("admin") Admin admin){
        System.out.println("进入管理员添加");
        boolean u=adminService.processAddAdmin(admin);
        if(u==false)
        {
            return "admin_add_user";
        }else
        {
            return "admin_list";
        }
    }

    /**
     * 删除管理员
     * @param admin
     * @return
     */
    @RequestMapping("/add")
    public String  deleteAdmin(@ModelAttribute("admin") Admin admin){
        return "admin_add_user";
    }

    /**
     * 查看所有admin
     * @param model
     * @return
     */
    @RequestMapping("/adminList")
    public String  listAdmin(Model model){
        List<Admin> admins=adminService.processlistAdmin(1,2);
        model.addAttribute("allAdmin",admins);
        for (Admin a:admins){
            System.out.println(a);
        } return "admin_list";
    }


    @RequestMapping("/exportAdmin")
    public void export(HttpServletResponse response) throws Exception {
        InputStream is = adminService.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is, output);
    }
}

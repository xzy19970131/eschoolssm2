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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
    public String  processLogin(HttpServletRequest request,@ModelAttribute("admin") Admin admin){
        System.out.println(admin);
        Admin u=adminService.processLogin(admin);
        if(u==null)
        {
            return "login";
        }else
        {
            HttpSession session = request.getSession();
            session.setAttribute("admin",admin);
            System.out.println("进入管理员登录"+admin);
            return "admin_add_user";
        }

    }

    @RequestMapping("/addAdmin")
    public String  adminAdd(HttpServletRequest request,@ModelAttribute("admin") Admin admin){
        System.out.println("进了Control的addAdmin");

        System.out.println("输出:"+admin);
        Boolean result=adminService.processAddAdmin(admin);
        if(result==false)
        {
            return "admin_add_user";
        }else
        {
            return "admin_list";
        }
/*        request.getParameter("");*/

    }

    /**
     * 删除管理员
     * @param adminid
     * @return
     */
    @RequestMapping(value = "/deleteAdmin")
    public String  deleteAdmin(@RequestParam("adminid")int adminid,Model model){
        System.out.println("进入到删除admin");
        System.out.println("adminid:"+adminid);
        adminService.processdeleteAdmin(adminid);
        List<Admin> admins=adminService.processlistAdmin(1,2);
        model.addAttribute("allAdmin",admins);
        return "admin_list";

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
    /**
     * 管理员注销登录
     * @param session
     * @return
     */
    @RequestMapping("/adminout")
    public String  outAdminlogin(HttpSession session){
        System.out.println("进入到管理员注销登录");
       session.invalidate();
       return "login";
    }

    @RequestMapping("/exportAdmin")
    public void export(HttpServletResponse response) throws Exception {
        System.out.println("进入到导出adminExcel");
        InputStream is = adminService.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("contentDisposition", "attachment;filename=AllAdmins.xls");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is, output);
    }




}

package com.oracle.eschoolssm.control;


import com.oracle.eschoolssm.model.bean.Admin;
import com.oracle.eschoolssm.model.dao.AdminDAO;
import com.oracle.eschoolssm.service.AdminService;

import org.apache.ibatis.session.SqlSession;
import org.apache.poi.util.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @RequestMapping("/login")
    public String  processLogin(@ModelAttribute("admin") Admin admin){
        System.out.println("前："+admin);
        Admin u=adminService.processLogin(admin);
        System.out.println("后："+u);
        if(u==null)
        {
            return "login";
        }else
        {
                    return "admin_add_user";
        }

    }
    @RequestMapping("/add")
    public String  addAdmin(@ModelAttribute("admin") Admin admin){


        return "admin_add_user";
    }
    @RequestMapping("/list")
    public String  listAdmin(@ModelAttribute("admin") Admin admin){

        return "xxx.jsp";
    }


    /*列出所有管理员*/
    @RequestMapping("/adminList")
    public String  listAdmin(Model model){
        //SqlSession session= SessionFactoryHelper.getSf().openSession();
        //AdminDAO dao = session.getMapper(AdminDAO.class);

       // List<Admin> admins=AdminDAO.listAdmin(1,2);
        List<Admin> admins=adminService.processlistAdmin(1,2);
    /*    model.addAttribute("aaa",111);*/
        model.addAttribute("allAdmin",admins);

        for (Admin a:admins){
            System.out.println(a);
        } return "admin_list";
    }

    @RequestMapping("/exportAdmin")
    public void export(HttpServletResponse response) throws Exception{
        InputStream is=adminService.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is,output);
    }

}

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
    private UserService userService;
    public AdminService getAdminService() {
        return adminService;
    }

    public void setAdminService(AdminService adminService) {
        this.adminService = adminService;
    }

    public UserService getUserService() {
        return userService;
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
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
    public void export(HttpServletResponse response) throws Exception {
        InputStream is = adminService.getInputStream();
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("contentDisposition", "attachment;filename=AllUsers.xls");
        ServletOutputStream output = response.getOutputStream();
        IOUtils.copy(is, output);
    }


    /*列出所有User*/
        @RequestMapping(value = "/userList")
        public String listUser (Model model){
            // SqlSession session= SessionFactoryHelper.getSf().openSession();
            //UserDAO dao = session.getMapper(UserDAO.class);
            List<User> users = userService.processlistUser(1, 2);
    /*    model.addAttribute("aaa",111);*/
            model.addAttribute("allUser", users);

            for (User u : users) {
                System.out.println(u);
            }
            return "auser_list";
        }

    /*根据userid取得User*/
    @RequestMapping(value = "/userDetail"/*,params = "userid"*/)
    public String  getUserByID(@RequestParam("userid")int userid,Model model){
        //SqlSession session= SessionFactoryHelper.getSf().openSession();
        //UserDAO dao = session.getMapper(UserDAO.class);
       // User user =dao.getUserByID(userid);
        User user =userService.processgetUserByID(userid);
        model.addAttribute("user",user);
        return "auser_detail";

    }

}

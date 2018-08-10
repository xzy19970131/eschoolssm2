package com.oracle.eschoolssm.control;


import com.oracle.eschoolssm.model.bean.Admin;
import com.oracle.eschoolssm.model.bean.User;
import com.oracle.eschoolssm.model.dao.AdminDAO;
import com.oracle.eschoolssm.model.dao.SessionFactoryHelper;
import com.oracle.eschoolssm.model.dao.UserDAO;
import com.oracle.eschoolssm.service.AdminService;

import com.sun.swing.internal.plaf.metal.resources.metal;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        SqlSession session= SessionFactoryHelper.getSf().openSession();
        AdminDAO dao = session.getMapper(AdminDAO.class);
        List<Admin> admins=dao.listAdmin(1,2);
    /*    model.addAttribute("aaa",111);*/
        model.addAttribute("allAdmin",admins);

        for (Admin a:admins){
            System.out.println(a);
        } return "admin_list";
    }


    /*列出所有User*/
    @RequestMapping("/userList")
    public String  listLUser(Model model){
        SqlSession session= SessionFactoryHelper.getSf().openSession();
        UserDAO dao = session.getMapper(UserDAO.class);
        List<User> users=dao.listUser(1,2);
    /*    model.addAttribute("aaa",111);*/
        model.addAttribute("allUser",users);

        for (User u:users){
            System.out.println(u);
        } return "auser_list";
    }

    /*根据userid取得User*/
    @RequestMapping(value = "/userDetail"/*,params = "userid"*/)
    public String  getUserByID(@RequestParam("userid")int userid,Model model){
        SqlSession session= SessionFactoryHelper.getSf().openSession();
        UserDAO dao = session.getMapper(UserDAO.class);
        User user =dao.getUserByID(userid);
        model.addAttribute("user",user);
        return "auser_detail";
    }

}

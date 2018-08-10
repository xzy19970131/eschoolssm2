package com.oracle.eschoolssm.service;


import com.oracle.eschoolssm.model.bean.Admin;
import com.oracle.eschoolssm.model.dao.AdminDAO;
import org.springframework.stereotype.Controller;


@Controller("adminService")
public class AdminServiceImp implements AdminService {

    private AdminDAO  adminDAO;

    public AdminDAO getAdminDAO() {
        return adminDAO;
    }

    public void setAdminDAO(AdminDAO adminDAO) {
        this.adminDAO = adminDAO;
    }
    //管理员登录
    public Admin processLogin(Admin admin) {
        Admin u= adminDAO.getInfoByUAndP(admin.getUsername(),admin.getPassword());
        return u;
    }
    //管理员添加
    public Admin processAddAdmin(Admin admin) {
        return null;
    }

}

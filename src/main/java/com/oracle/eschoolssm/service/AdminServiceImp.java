package com.oracle.eschoolssm.service;


import com.oracle.eschoolssm.model.bean.Admin;
import com.oracle.eschoolssm.model.bean.User;
import com.oracle.eschoolssm.model.dao.AdminDAO;
import com.oracle.eschoolssm.model.dao.UserDAO;
import com.oracle.eschoolssm.util.WriteExcel;
import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


@Controller("adminService")
public class AdminServiceImp implements AdminService {

    private AdminDAO  adminDAO;
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

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

    public List<Admin> processlistAdmin(int count, int page) {
        List<Admin> u=adminDAO.listAdmin(1,2);
        return u;
    }
/*
    public List<User> processlistUser(int count, int page) {
        List<User> u=userDAO.listUser(1,2);
        return u;
    }
*/
    public InputStream getInputStream() throws Exception {
        String[] title=new String[]{"adminid","username","password","xingming","phone","address"};
        List<Admin> plist=adminDAO.getAdminList();
        List<Object[]> dataList = new ArrayList<Object[]>();
        for(int i=0;i<plist.size();i++){
            Object[] obj=new Object[6];
            obj[0]=plist.get(i).getAdminid();
            obj[1]=plist.get(i).getUsername();
            obj[2]=plist.get(i).getPassword();
            obj[3]=plist.get(i).getXingming();
            obj[4]=plist.get(i).getPhone();
            obj[5]=plist.get(i).getAddress();
            dataList.add(obj);
        }
        WriteExcel ex = new WriteExcel(title, dataList);
        InputStream in;
        in = ex.export();
        return in;
    }

}

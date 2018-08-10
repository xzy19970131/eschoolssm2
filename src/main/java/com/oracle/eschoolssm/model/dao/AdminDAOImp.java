package com.oracle.eschoolssm.model.dao;


import com.oracle.eschoolssm.model.bean.Admin;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller("adminDAO")
public class AdminDAOImp extends BaseDAO implements AdminDAO {
    //管理员登录
    public Admin getInfoByUAndP(String username, String password) {
       AdminDAO dao= getSession().getMapper(AdminDAO.class);
        return  dao.getInfoByUAndP(username,password);

    }
    //添加管理员
    public boolean addAdmin(Admin admin) {
        return false;
    }

    public boolean deleteAdmin(int adminid) {
        return false;
    }

    //列出所有管理员的信息
    public List<Admin> listAdmin(int count, int page) {
        return null;
    }
}

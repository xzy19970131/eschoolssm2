package com.oracle.eschoolssm.model.dao;


import com.oracle.eschoolssm.model.bean.Admin;
import org.springframework.stereotype.Controller;

import java.util.List;


@Controller("adminDAO")
public class AdminDAOImp extends BaseDAO implements AdminDAO {
    //管理员登录
    public Admin getInfoByUAndP(String username, String password) {
       AdminDAO dao= getSqlSession().getMapper(AdminDAO.class);
        return  dao.getInfoByUAndP(username,password);

    }
    //添加管理员
    public boolean addAdmin(Admin admin) {
        System.out.println("进了Dao的"+admin);
        AdminDAO dao= getSqlSession().getMapper(AdminDAO.class);
        return  dao.addAdmin(admin);
    }
    //删除管理员
    public boolean deleteAdmin(int adminid) {
        AdminDAO dao=getSqlSession().getMapper(AdminDAO.class);
        return dao.deleteAdmin(adminid);

    }

    //列出所有管理员的信息
    public List<Admin> listAdmin(int count, int page) {
        AdminDAO dao=getSqlSession().getMapper(AdminDAO.class);
        return dao.listAdmin(1,2);
    }
    //Excel导出所有管理员的信息
    public List<Admin> getAdminList() {
        AdminDAO dao=getSqlSession().getMapper(AdminDAO.class);
        return dao.getAdminList();
    }

}

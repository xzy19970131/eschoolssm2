package com.oracle.eschoolssm.model.dao;


import com.oracle.eschoolssm.model.bean.Admin;

import java.util.List;

public interface AdminDAO {
    //管理员登录
    public Admin getInfoByUAndP(String username, String password);
    //添加管理员
    public boolean addAdmin(Admin admin);
    //删除管理员
    public boolean deleteAdmin(int adminid);
    //列出所有管理员的信息
    public List<Admin> listAdmin(int count, int page);
}

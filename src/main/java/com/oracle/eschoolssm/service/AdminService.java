package com.oracle.eschoolssm.service;


import com.oracle.eschoolssm.model.bean.Admin;



public interface AdminService {
    public Admin  processLogin(Admin admin);
    public Admin processAddAdmin(Admin admin);
}

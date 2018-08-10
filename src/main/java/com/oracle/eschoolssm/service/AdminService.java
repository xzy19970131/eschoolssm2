package com.oracle.eschoolssm.service;


import com.oracle.eschoolssm.model.bean.Admin;

import java.io.InputStream;


public interface AdminService {
    public Admin  processLogin(Admin admin);
    public Admin processAddAdmin(Admin admin);
    InputStream getInputStream() throws Exception;
}

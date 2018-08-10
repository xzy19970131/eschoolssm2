package com.oracle.eschoolssm.service;


import com.oracle.eschoolssm.model.bean.Admin;

import java.io.InputStream;
import java.util.List;


public interface AdminService {
    public Admin  processLogin(Admin admin);
    public Admin processAddAdmin(Admin admin);
    public List<Admin> processlistAdmin(int count, int page);
    InputStream getInputStream() throws Exception;
}

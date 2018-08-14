package com.oracle.eschoolssm.service;


import com.oracle.eschoolssm.model.bean.Admin;

import java.io.InputStream;
import java.util.List;


public interface AdminService {
    /**
     * service处理管理员登录
     * @param admin
     * @return
     */
    public Admin  processLogin(Admin admin);

    /**
     * service处理管理员添加
     * @param admin
     * @return
     */
    public boolean processAddAdmin(Admin admin);
    public boolean processdeleteAdmin(int adminid);

    /**
     * service处理列出所有管理员信息
     * @param count
     * @param page
     * @return
     */
    public List<Admin> processlistAdmin(int count, int page);

    /**
     *service处理管理员导出Excel
     * @return
     * @throws Exception
     */
    InputStream getInputStream() throws Exception;
}

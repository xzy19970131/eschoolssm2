package com.oracle.eschoolssm.service;


import com.oracle.eschoolssm.model.bean.Admin;
import com.oracle.eschoolssm.model.dao.AdminDAO;
import com.oracle.eschoolssm.util.WriteExcel;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Transactional(propagation= Propagation.REQUIRED,isolation= Isolation.DEFAULT,timeout=5)
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
    public boolean processAddAdmin(Admin admin) {
        Boolean aBoolean = adminDAO.addAdmin(admin);
        return aBoolean;
    }

    public boolean processdeleteAdmin(int adminid) {
         Boolean aBoolean=adminDAO.deleteAdmin(adminid);

         return aBoolean;
    }

    public List<Admin> processlistAdmin(int count, int page) {
        List<Admin> u=adminDAO.listAdmin(1,2);
        return u;
    }

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

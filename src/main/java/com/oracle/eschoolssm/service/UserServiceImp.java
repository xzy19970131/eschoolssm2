package com.oracle.eschoolssm.service;


import com.oracle.eschoolssm.model.bean.User;
import com.oracle.eschoolssm.model.dao.UserDAO;
import com.oracle.eschoolssm.util.WriteExcel;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
@Controller("userService")
public class UserServiceImp implements UserService{
    private UserDAO userDAO;

    public UserDAO getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User processgetUserByID(int userid) {
        User user=userDAO.getUserByID(userid);
        return user;
    }

    public List<User> processlistUser(int page, int count) {
        List<User> u=userDAO.listUser(1,2);
        return u;
    }
    public InputStream getInputStream() throws Exception {
        String[] title=new String[]{"userid","username","password","sex","age","qq","phone","email","image","address","createtime","statue","realname"};
        List<User> plist=userDAO.getUserList();
        List<Object[]> dataList = new ArrayList<Object[]>();
        for(int i=0;i<plist.size();i++){
            Object[] obj=new Object[13];
            obj[0]=plist.get(i).getUserid();
            obj[1]=plist.get(i).getUsername();
            obj[2]=plist.get(i).getPassword();
            obj[3]=plist.get(i).getSex();
            obj[4]=plist.get(i).getAge();
            obj[5]=plist.get(i).getQq();
            obj[6]=plist.get(i).getPhone();
            obj[7]=plist.get(i).getEmail();
            obj[8]=plist.get(i).getImage();
            obj[9]=plist.get(i).getAddress();
            obj[10]=plist.get(i).getCreatetime();
            obj[11]=plist.get(i).getStatue();
            obj[12]=plist.get(i).getRealname();
            dataList.add(obj);
        }
        WriteExcel ex = new WriteExcel(title, dataList);
        InputStream in;
        in = ex.export();
        return in;
    }

}

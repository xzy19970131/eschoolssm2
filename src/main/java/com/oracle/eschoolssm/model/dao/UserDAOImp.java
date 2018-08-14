package com.oracle.eschoolssm.model.dao;


import com.oracle.eschoolssm.model.bean.User;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller("userDAO")
public class UserDAOImp extends BaseDAO implements UserDAO {
    //根据userID查看用户详情
    public User getUserByID(int userid) {
        UserDAO dao=getSqlSession().getMapper(UserDAO.class);
        return dao.getUserByID(userid);
    }
    //列出所有用户
    public List<User> listUser(int page, int count) {
        UserDAO dao=getSqlSession().getMapper(UserDAO.class);
        return dao.listUser(1,2);
    }
    //Excel导出所有用户信息
    public List<User> getUserList() {
        UserDAO dao=getSqlSession().getMapper(UserDAO.class);
        return dao.getUserList();
    }
}

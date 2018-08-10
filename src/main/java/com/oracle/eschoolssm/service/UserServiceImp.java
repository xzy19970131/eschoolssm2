package com.oracle.eschoolssm.service;

import com.oracle.eschoolssm.model.bean.User;
import com.oracle.eschoolssm.model.dao.UserDAO;
import org.springframework.stereotype.Controller;

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
}

package com.oracle.eschoolssm.model.dao;

import com.oracle.eschoolssm.model.bean.User;

import java.util.List;

public interface UserDAO {
    public User getUserByID(int userid);
    public List<User> listUser(int count, int page);
}

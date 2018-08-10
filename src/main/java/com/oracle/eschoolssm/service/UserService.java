package com.oracle.eschoolssm.service;

import com.oracle.eschoolssm.model.bean.User;

import java.util.List;

public interface UserService {
    public User processgetUserByID(int userid);
    public List<User> processlistUser(int page, int count);
}

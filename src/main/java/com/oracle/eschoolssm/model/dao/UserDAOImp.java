package com.oracle.eschoolssm.model.dao;

import com.oracle.eschoolssm.model.bean.User;
import org.springframework.stereotype.Controller;

import java.util.List;
@Controller("userDAO")
public class UserDAOImp extends BaseDAO implements UserDAO {

    public User getUserByID(int userid) {
        UserDAO dao=getSqlSession().getMapper(UserDAO.class);
        return dao.getUserByID(userid);
    }

    public List<User> listUser(int page, int count) {
        UserDAO dao=getSqlSession().getMapper(UserDAO.class);
        return dao.listUser(1,2);
    }
}

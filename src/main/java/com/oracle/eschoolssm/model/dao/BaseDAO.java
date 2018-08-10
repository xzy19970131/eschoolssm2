package com.oracle.eschoolssm.model.dao;

import org.apache.ibatis.session.SqlSession;

public class BaseDAO {
    private SqlSession  session;
    public BaseDAO(){
        session=SessionFactoryHelper.getSf().openSession();
    }

    public SqlSession getSession() {
        return session;
    }
}
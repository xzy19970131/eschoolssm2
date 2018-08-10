package com.oracle.eschoolssm.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.support.SqlSessionDaoSupport;

public class BaseDAO extends SqlSessionDaoSupport {
    private SqlSession sqlSession;

    @Override
    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public void setSqlSession(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }
}

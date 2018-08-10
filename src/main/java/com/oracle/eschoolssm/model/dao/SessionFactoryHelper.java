package com.oracle.eschoolssm.model.dao;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SessionFactoryHelper {
    private static SqlSessionFactory  sf;
    static{
        try
        {
            sf = new SqlSessionFactoryBuilder().build(Resources.getResourceAsReader("configuration.xml"));
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSessionFactory getSf() {
        return sf;
    }
}

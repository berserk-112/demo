package com.example.MyBatisTest;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String resource="mybatis-config.xml";
        ArrayList<String> list = new ArrayList<>();
        long i = 0;
        System.out.println(Main.class.getClassLoader());
        InputStream inputStream=null;
        try {
            inputStream = Resources.getResourceAsStream(resource);
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        SqlSessionFactory sqlSessionFactory=null;
        sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession=null;
        try {
            sqlSession=sqlSessionFactory.openSession();
            RoleMapper roleMapper=sqlSession.getMapper(RoleMapper.class);
            Role role=roleMapper.getRole(1L);
            Role testRole = new Role();
            testRole.setRoleName("userT");
            roleMapper.insertRole(testRole);
            System.out.println(role.getId()+":"+role.getRoleName()+":"+role.getNote());
            sqlSession.commit();
            sqlSession.rollback();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            sqlSession.rollback();
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }
}
package com.hazer.gyo.hazer.entity;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ProjectName: javacode
 * @Package: gyo.hazer.entity
 * @ClassName: mybatisTest
 * @Author: Hazer
 * @Description:
 * @Date: 2019/12/9 22:55
 * @Version: 1.0
 */
public class mybatisTest {
    public static void main(String[] args) throws IOException {
        //指定全局文件
        String resource = "mybatis-config.xml";
        // 读取配置文件
        InputStream inputStream = Resources.getResourceAsStream(resource);
        // 构建sqlSessionFactory
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        // 获取sqlSession
        SqlSession sqlSession = null;
        try {
            sqlSession = sessionFactory.openSession();
            Person person1 = new Person(25, "zzccc", "女");
            sqlSession.insert("personMapper.insertPerson", person1);
            sqlSession.commit();
            Person person = sqlSession.selectOne("personMapper.selectPerson", 3);

            System.out.println(person.toString());

        } finally {
            sqlSession.close();
        }

    }
}

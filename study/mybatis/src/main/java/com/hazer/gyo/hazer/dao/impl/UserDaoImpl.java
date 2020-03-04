package com.hazer.gyo.hazer.dao.impl;

import com.hazer.gyo.hazer.dao.UserDao;
import com.hazer.gyo.hazer.entity.User;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @ProjectName: javacode
 * @Package: gyo.hazer.dao.impl
 * @ClassName: UserDaoImpl
 * @Author: Hazer
 * @Description:
 * @Date: 2019/12/10 22:04
 * @Version: 1.0
 */
public class UserDaoImpl implements UserDao {
    public SqlSession sqlSession;

    public UserDaoImpl(SqlSession sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public User queryUserById(Integer id) {
        return this.sqlSession.selectOne("userDao.selectUserById",id);
    }

    @Override
    public List<User> queryUserAll() {
        return this.sqlSession.selectList("userDao.selectAll");
    }

    @Override
    public void insertUser(User user) {
         this.sqlSession.insert("userDao.insertUser",user);
    }

    @Override
    public void updateUser(User user) {
        this.sqlSession.insert("userDao.updateUser",user);
    }

    @Override
    public void deleteUser(Integer id) {
        this.sqlSession.delete("userDao.deleteUser",id);
    }
}

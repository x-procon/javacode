package gyo.hazer.dao;

import gyo.hazer.entity.User;

import java.util.List;

/**
 * @ProjectName: javacode
 * @Package: gyo.hazer.dao
 * @ClassName: UserDao
 * @Author: Hazer
 * @Description:
 * @Date: 2019/12/10 22:03
 * @Version: 1.0
 */
public interface UserDao {
    /**
     * 根据id查询用户信息
     *
     * @param id
     * @return
     */
    public User queryUserById(Integer id);

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> queryUserAll();

    /**
     * 新增用户
     *
     * @param user
     */
    public void insertUser(User user);

    /**
     * 更新用户信息
     *
     * @param user
     */
    public void updateUser(User user);

    /**
     * 根据id删除用户信息
     *
     * @param id
     */
    public void deleteUser(Integer id);

}

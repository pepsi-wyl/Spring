package dao;

import pojo.User;

import java.util.List;

/**
 * @author by wyl
 * @date 2021/11/4.20点58分
 */
public interface UserDao {

    /**
     * 添加用户
     */
    int addUser(User user);

    /**
     * 通过ID删除用户
     */
    int deleteUserByID(int id);

    /**
     * 修改用户
     */
    int updateUser(User user);

    /**
     * 查询用户的个数
     */
    int queryCount();

    /**
     * 查询UserByID
     */
    User queryUserByID(int id);

    /**
     * 查询所有用户
     */
    List<User> queryUserList();

    /**
     * 批量添加
     */
    int[] addUserBatch(List<Object[]> batchArgs);

    /**
     * 批量修改
     */
    int[] updateUserBatch(List<Object[]> batchArgs);

    /**
     * 批量删除
     */
    int[] deleteUserBatch(List<Object[]> batchArgs);

}

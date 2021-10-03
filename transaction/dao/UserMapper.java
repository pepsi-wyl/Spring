package dao;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

/**
 * @author by wyl
 * @date 2021/9/26.19点58分
 */
public interface UserMapper {

    /**
     * 查询所有用户的信息
     */
    List<User> getUserList();

    /**
     * 添加用户信息
     */
    int addUser(User user);

    /**
     * 删除用户信息
     */
    int deleteUser(@Param("id") int id);

}

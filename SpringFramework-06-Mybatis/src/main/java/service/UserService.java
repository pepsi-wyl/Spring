package service;

import org.apache.ibatis.annotations.Param;
import pojo.User;

import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 16:54
 */
public interface UserService {

    /**
     * 查找所有用户
     */
    List getUserList();

    /**
     * 得到用户的数量
     */
    int getUserCount();

    /**
     * 添加用户
     */
    int addUser( User user);

    /**
     * 通过ID删除用户
     */
    int deleteUserByID(@Param("id") int id);

    /**
     * 修改用户
     */
    int modifyUserById(User user);
}

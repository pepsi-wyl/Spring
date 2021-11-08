package dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import pojo.User;

import java.util.List;


/**
 * @author by wyl
 * @date 2021/9/26.19点15分
 */

public class UserMapperImplExtends extends SqlSessionDaoSupport implements UserMapper {

    /**
     * 查找所有用户
     */
    @Override
    public List getUserList() {
        return getSqlSession().getMapper(UserMapper.class).getUserList();
    }

    /**
     * 得到用户的数量
     */
    @Override
    public int getUserCount() {
        return getSqlSession().getMapper(UserMapper.class).getUserCount();
    }

    /**
     * 删除用户ByID
     */
    @Override
    public int deleteUserByID(int id) {
        return getSqlSession().getMapper(UserMapper.class).deleteUserByID(id);
    }

    /**
     * 添加用户
     */
    @Override
    public int addUser(User user) {
        return getSqlSession().getMapper(UserMapper.class).addUser(user);
    }

    /**
     * 修改用户
     */
    @Override
    public int modifyUserById(User user) {
        return getSqlSession().getMapper(UserMapper.class).modifyUserById(user);
    }

}


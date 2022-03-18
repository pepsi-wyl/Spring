package service;

import mapper.UserMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 16:54
 */

@Transactional
        (
                propagation = Propagation.REQUIRED,
                isolation = Isolation.REPEATABLE_READ,
                timeout = 10,
                readOnly = false
        )// 配置事务

@Scope("singleton")
@Component(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public List getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserByID(int id) {
        return userMapper.deleteUserByID(id);
    }

    @Override
    public int modifyUserById(User user) {
        return userMapper.modifyUserById(user);
    }
}

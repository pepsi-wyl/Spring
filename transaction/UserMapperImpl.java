package dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pojo.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by wyl
 * @date 2021/9/26.
 */
@Repository
@Scope("singleton")      //Bean作用域

public class UserMapperImpl implements UserMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List<User> getUserList() {
        sqlSessionTemplate.getMapper(UserMapper.class).addUser(new User(5, "zhazha", "888888"));
        sqlSessionTemplate.getMapper(UserMapper.class).deleteUser(5);
        return sqlSessionTemplate.getMapper(UserMapper.class).getUserList();
    }

    @Override
    public int addUser(User user) {
        return sqlSessionTemplate.getMapper(UserMapper.class).addUser(user);
    }

    @Override
    public int deleteUser(int id) {
        return sqlSessionTemplate.getMapper(UserMapper.class).deleteUser(id);
    }

}

package dao;

import lombok.*;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pojo.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by wyl
 * @date 2021/9/26.
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAspectJAutoProxy

@Repository
@Scope("singleton")      //Bean作用域

public class UserMapperImpl implements UserMapper {

    /**
     * 注入sqlSessionTemplate
     */
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    /*
     *
     */
    @Override
    public List<User> getUserList() {
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


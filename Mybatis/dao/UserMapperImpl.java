package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
import pojo.User;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by wyl
 * @date 2021/9/26.16点14分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Repository(value = "userMapperImpl")
@Scope("singleton")        //Bean作用域

public class UserMapperImpl implements UserMapper {

    /**
     * 注入sqlSessionTemplate
     */
    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    /**
     * 查找所有用户
     */
    @Override
    public List getUserList() {
        return sqlSessionTemplate.getMapper(UserMapper.class).getUserList();
    }

    /**
     * 得到用户的数量
     */
    @Override
    public int getUserCount() {
        return sqlSessionTemplate.getMapper(UserMapper.class).getUserCount();
    }

    /**
     * 删除用户ByID
     */
    @Override
    public int deleteUserByID(int id) {
        return sqlSessionTemplate.getMapper(UserMapper.class).deleteUserByID(id);
    }

    /**
     *添加用户
     */
    @Override
    public int addUser(User user) {
        return sqlSessionTemplate.getMapper(UserMapper.class).addUser(user);
    }

    /**
     *修改用户
     */
    @Override
    public int modifyUserById(User user) {
        return sqlSessionTemplate.getMapper(UserMapper.class).modifyUserById(user);
    }

}


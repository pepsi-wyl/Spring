package dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

/**
 * @author by wyl
 * @date 2021/9/26.19点15分
 */

/**
    <bean id="userMapper2" class="dao.UserMapperImpl2">
        <property name="sqlSessionFactory" ref="sqlSessionFactory"></property>
    </bean> 
 */

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper {

    @Override
    public List getUserList() {
        return getSqlSession().getMapper(UserMapper.class).getUserList();
    }

}

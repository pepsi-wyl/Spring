package service;

import dao.UserDao;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author by wyl
 * @date 2021/9/25.
 */


/**
 * @Service Service
 * <bean id="userDaoImpl" class="dao.userDaoImpl"/>  注册bean
 */
//@Service        //默认为类名小写
@Service(value = "userServiceImpl")  //value为userService

//作用域
@Scope("singleton")  //singleton 单例模式   prototype 原型模式

@Data
@NoArgsConstructor
@EqualsAndHashCode

public class UserServiceImpl implements UserService {


    /**
     * 用于构造器注入
     * @Autowired 按照类型(byType)装配依赖对象
     * @Autowired(required = false/true)   允许null值/不允许null值
     * @Qualifier(value = "xxx")      按照名称(byName)来装配
     * 注意:可以结合@Qualifier注解一起使用
     */

    private UserDao userDao;

    @Autowired(required = false)
    public UserServiceImpl(@Qualifier(value = "userDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void test() {
        System.out.println("UserService");
    }

}

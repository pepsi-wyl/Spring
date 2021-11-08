package dao;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;

/**
 * @author by wyl
 * @date 2021/9/25.08点51分
 */

/**
 * Repository  DAO
 * <bean id="userDaoImpl" class="dao.userDaoImpl"/>  注册bean
 */
//@Repository         //默认为类名小写
@Repository(value = "userDaoImpl")    //value为userDaoImpl

//作用域
@Scope("singleton")    //singleton 单例模式   prototype 原型模式

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class UserDaoImpl implements UserDao {

    @Value("str")
    private String string;

    /**
     * test方法
     */
    @Override
    public void test() {
        System.out.println("UserDao");
    }

}

package dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

/**
 * @author by wyl
 * @date 2021/9/25.21点06分
 */

@Repository(value = "userDaoImpl")
@Scope("singleton")

public class UserDaoImpl implements UserDao {
    /**
     * 测试方法
     */
    @Override
    public void add() {
        System.out.println("add");
    }
}

package dao;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author by wyl
 * @date 2021/9/25.21点06分
 */

@Component
@Scope("singleton")

public class UserDaoImpl implements UserDao {

    @Override
    public void add() {
        System.out.println("add");
    }

    @Override
    public void delete() {
        System.out.println("delete");
    }

    @Override
    public void query() {
        System.out.println("query");
    }

    @Override
    public void modify() {
        System.out.println("modify");
    }

}

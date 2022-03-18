package service;

import dao.UserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import utils.ApplicationContextUtils;

import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 11:16
 */

/**
 * 注解配置事务 @Transactional            可以加在类上/方法上
 * propagation:    事务传播行为(7种)      REQUIRED   REQUIRES_NEW    (事务如何执行)
 * isolation:      事务隔离级别           MYSQL默认:REPEATABLE_READ(不可重复读)
 * timeout:        超时时间              默认-1(不超时)  可以设置 S为单位    (在一定事件内提交，否则回滚)
 * readOnly:       是否只读              默认:false  true只能执行查询操作
 * rollbackFor:    回滚                 配置异常类型      (设置出现那些异常回滚)
 * noRollbackFor:  不回滚               配置异常类型      (设置出现那些异常不回滚)
 */
@Transactional
        (
                propagation = Propagation.REQUIRED,
                isolation = Isolation.REPEATABLE_READ,
                timeout = 10,
                readOnly = false
        )

@Service(value = "userServiceImpl")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    /**
     * UserDao实现类对象
     */
    private final UserDao userDao;

    public UserServiceImpl(@Qualifier(value = "userDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 添加user对象
     */
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * 删除user对象 ById
     */
    @Override
    public int deleteUserByID(int id) {
        return userDao.deleteUserByID(id);
    }

    /**
     * 修改user对象 ById
     */
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * 查询UserCount
     */
    @Override
    public int queryCount() {
        return userDao.queryCount();
    }

    /**
     * 查询UserByID
     */
    @Override
    public User queryUserByID(int id) {
        return userDao.queryUserByID(id);
    }

    /**
     * 查询所有用户
     */
    @Override
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }

    /**
     * 批量添加
     */
    @Override
    public int[] addUserBatch(List<Object[]> batchArgs) {
        return userDao.addUserBatch(batchArgs);
    }

    /**
     * 批量修改
     */
    @Override
    public int[] updateUserBatch(List<Object[]> batchArgs) {
        return userDao.updateUserBatch(batchArgs);
    }

    /**
     * 批量删除
     */
    @Override
    public int[] deleteUserBatch(List<Object[]> batchArgs) {
        return userDao.deleteUserBatch(batchArgs);
    }

    /**
     * 事务的测试  异常
     */
    @Override
    public void add_del() {
        User user = ApplicationContextUtils.getApplicationContext().getBean("user", User.class);
        user.setId(1000);
        user.setName("zhazha");
        user.setPwd("888888");
        userDao.addUser(user);
        int num = 10 / 0;
        userDao.deleteUserByID(1000);
        userDao.queryUserList().forEach(System.out::println);
    }

}

import Utils.ApplicationContextUtils;
import dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import pojo.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by wyl
 * @date 2021/11/5.10点21分
 */

public class jdbcTemplate_T {

    /**
     * jdbcTemplate操作数据库
     */
    @Test      //添加用户
    public void addUser_JdbcTemplate() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        User user = applicationContext.getBean("user", User.class);
        user.setId(20000);
        user.setName("zhazha");
        user.setPwd("888888");
        System.out.println(userDao.addUser(user) > 0 ? "success" : "error");
    }

    @Test     //删除用户
    public void deleteUserByID_JdbcTemplate() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        System.out.println(userDao.deleteUserByID(20000) > 0 ? "success" : "error");
    }

    @Test     //修改用户
    public void updateUser_JdbcTemplate() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        User user = applicationContext.getBean("user", User.class);
        user.setId(20000);
        user.setName("zha");
        user.setPwd("888888");
        System.out.println(userDao.updateUser(user) > 0 ? "success" : "error");
    }

    @Test    //查询用户个数
    public void queryCount_JdbcTemplate() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        System.out.println(userDao.queryCount());
    }

    @Test    //通过ID查找用户
    public void queryUserByID_JdbcTemplate() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        User user = userDao.queryUserByID(4);
        System.out.println(user);
    }

    @Test    //查找所有用户
    public void queryUserList_JdbcTemplate() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        List<User> userList = userDao.queryUserList();
        userList.forEach((v) -> System.out.println(v));
    }

    @Test   //批量添加
    public void addUserBatch_JdbcTemplate() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        ArrayList<Object[]> batchArgs = new ArrayList<>();
        Object[] user1 = {1, "zhazha", "888888"};
        Object[] user2 = {2, "zhazha", "888888"};
        batchArgs.add(user1);
        batchArgs.add(user2);
        int[] ints = userDao.addUserBatch(batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Test   //批量修改
    public void updateUserBatch_JdbcTemplate() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        ArrayList<Object[]> batchArgs = new ArrayList<>();
        Object[] user1 = {"zhazha", "999999", 1};
        Object[] user2 = {"zhazha", "999999", 2};
        batchArgs.add(user1);
        batchArgs.add(user2);
        int[] ints = userDao.updateUserBatch(batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    @Test   //批量删除
    public void deleteUserBatch_JdbcTemplate() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = applicationContext.getBean("userDaoImpl", UserDao.class);
        ArrayList<Object[]> batchArgs = new ArrayList<>();
        Object[] user1 = {1};
        Object[] user2 = {2};
        batchArgs.add(user1);
        batchArgs.add(user2);
        int[] ints = userDao.deleteUserBatch(batchArgs);
        System.out.println(Arrays.toString(ints));
    }

}

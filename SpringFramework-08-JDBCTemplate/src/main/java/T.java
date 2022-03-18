import config.config;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pojo.User;
import service.UserService;

import utils.ApplicationContextUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-23 21:21
 */

public class T {

    /**
     * 添加用户
     */
    @Test
    public void addUser() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        User user = applicationContext.getBean("user", User.class);
        user.setId(20000);
        user.setName("zhazha");
        user.setPwd("888888");
        System.out.println(userService.addUser(user) > 0 ? "success" : "error");
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUserByID() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        System.out.println(userService.deleteUserByID(20000) > 0 ? "success" : "error");
    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        User user = applicationContext.getBean("user", User.class);
        user.setId(20000);
        user.setName("zha");
        user.setPwd("888888");
        System.out.println(userService.updateUser(user) > 0 ? "success" : "error");
    }

    /**
     * 查询用户个数
     */
    @Test
    public void queryCount() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        System.out.println(userService.queryCount());
    }

    /**
     * 通过ID查找用户
     */
    @Test
    public void queryUserByID() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        User user = userService.queryUserByID(4);
        System.out.println(user);
    }

    /**
     * 查找所有用户 List集合
     */
    @Test
    public void queryUserList() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        List<User> userList = userService.queryUserList();
        userList.forEach(System.out::println);
    }

    /**
     * 批量添加
     */
    @Test
    public void addUserBatch() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);

        ArrayList<Object[]> batchArgs = new ArrayList<>();
        Object[] user1 = {1, "zhazha", "888888"};
        Object[] user2 = {2, "zhazha", "888888"};
        batchArgs.add(user1);
        batchArgs.add(user2);

        int[] ints = userService.addUserBatch(batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 批量修改
     */
    @Test
    public void updateUserBatch() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);

        ArrayList<Object[]> batchArgs = new ArrayList<>();
        Object[] user1 = {"zhazha", "999999", 1};
        Object[] user2 = {"zhazha", "999999", 2};
        batchArgs.add(user1);
        batchArgs.add(user2);

        int[] ints = userService.updateUserBatch(batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteUserBatch() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);

        ArrayList<Object[]> batchArgs = new ArrayList<>();
        Object[] user1 = {1};
        Object[] user2 = {2};
        batchArgs.add(user1);
        batchArgs.add(user2);

        int[] ints = userService.deleteUserBatch(batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 事务测试
     */
    @Test
    public void add_delXML() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        userService.add_del();
    }


    @Test
    public void add_del() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(config.class);
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        userService.add_del();
    }

}

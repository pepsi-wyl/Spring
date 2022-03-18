import Utils.ApplicationContextUtils;
import mapper.UserMapper;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import pojo.User;
import service.UserService;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 16:54
 */
public class T {

    @Test    //得到用户集合
    public void getUserList_Impl() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        userService.getUserList().forEach(System.out::println);
    }

    @Test   //得到用户数量
    public void getUserCount_Impl() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        int count = userService.getUserCount();
        System.out.println(count);
    }

    @Test   //删除用户ById
    public void deleteUserByID_Impl() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        int i = userService.deleteUserByID(1);
        System.out.println(i);
    }

    @Test   //添加用户
    public void addUser_Impl() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        User user = applicationContext.getBean("user", User.class);
        user.setId(1);
        user.setName("zhazha");
        user.setPwd("888888");
        int i = userService.addUser(user);
        System.out.println(i);
    }

    @Test   //修改用户
    public void modifyUserById_Impl() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        int i = userService.modifyUserById(new User(1, "zha", "999999"));
        System.out.println(i);
    }

}

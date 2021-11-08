import Utils.ApplicationContextUtils;
import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import pojo.User;

/**
 * @author by wyl
 * @date 2021/9/26.15点12分
 */
public class SqlSessionTemplate_T {

    /**
     * 通过sqlSessionTemplate直接操作数据库
     */
    @Test
    public void getUserList_sqlSession() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        SqlSession sqlSession = applicationContext.getBean("sqlSession", SqlSession.class);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.getUserList().forEach((v) -> System.out.println(v));
    }

    /**
     * impl
     */
    @Test    //得到用户集合
    public void getUserList_Impl() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserMapper userMapper = applicationContext.getBean("userMapperImpl", UserMapper.class);
        userMapper.getUserList().forEach((v) -> System.out.println(v));
    }

    @Test   //得到用户数量
    public void getUserCount_Impl(){
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserMapper userMapper = applicationContext.getBean("userMapperImpl", UserMapper.class);
        int count = userMapper.getUserCount();
        System.out.println(count);
    }

    @Test   //删除用户ById
    public void deleteUserByID_Impl() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserMapper userMapper = context.getBean("userMapperImpl", UserMapper.class);
        int i = userMapper.deleteUserByID(1);
        System.out.println(i);
    }

    @Test   //添加用户
    public void addUser_Impl() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserMapper userMapper = context.getBean("userMapperImpl", UserMapper.class);
        User user = context.getBean("user", User.class);
        user.setId(1);
        user.setName("zhazha");
        user.setPwd("888888");
        int i = userMapper.addUser(user);
        System.out.println(i);
    }

    @Test   //修改用户
    public void modifyUserById_Impl(){
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserMapper userMapper = context.getBean("userMapperImpl", UserMapper.class);
        int i = userMapper.modifyUserById(new User(1, "zha", "999999"));
        System.out.println(i);
    }





    /**
     * Extends
     */
    @Test    //得到用户集合
    public void getUserList_Extends() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserMapper mapper = applicationContext.getBean("userMapperExtends", UserMapper.class);
        mapper.getUserList().forEach((v) -> System.out.println(v));
    }

    @Test   //得到用户数量
    public void getUserCount_Extends(){
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserMapper userMapper = applicationContext.getBean("userMapperExtends", UserMapper.class);
        int count = userMapper.getUserCount();
        System.out.println(count);
    }

    @Test    //删除用户ById
    public void deleteUserByID_Extends() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserMapper mapper = context.getBean("userMapperExtends", UserMapper.class);
        int i = mapper.deleteUserByID(1);
        System.out.println(i);
    }

    @Test    //添加用户
    public void addUser_Extends() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserMapper mapper = context.getBean("userMapperExtends", UserMapper.class);
        User user = context.getBean("user", User.class);
        user.setId(1);
        user.setName("zhazha");
        user.setPwd("888888");
        int i = mapper.addUser(user);
        System.out.println(i);
    }

    @Test   //修改用户
    public void modifyUserById_Extends(){
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserMapper userMapper = context.getBean("userMapperExtends", UserMapper.class);
        int i = userMapper.modifyUserById(new User(1, "zha", "999999"));
        System.out.println(i);
    }

}


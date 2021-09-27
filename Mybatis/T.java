import Utils.ApplicationContextUtils;
import dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * @author by wyl
 * @date 2021/9/26.15点12分
 */
public class T {

    @Test
    public void t1() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserMapper userMapper = applicationContext.getBean("userMapperImpl", UserMapper.class);
        userMapper.getUserList().forEach((v) -> System.out.println(v));
    }

    @Test
    public void t2() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        SqlSession sqlSession = applicationContext.getBean("sqlSession", SqlSession.class);
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        mapper.getUserList().forEach((v) -> System.out.println(v));
    }

    @Test
    public void t3(){
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserMapper userMapper2 = applicationContext.getBean("userMapper2", UserMapper.class);
        userMapper2.getUserList().forEach((v) -> System.out.println(v));
    }

}

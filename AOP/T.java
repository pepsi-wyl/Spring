import config.ConfigAOP;
import dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import utils.ApplicationContextUtils;

/**
 * @author by wyl
 * @date 2021/9/25.12点42分
 */
public class T {

    @Test
    public void t_Annotation() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigAOP.class);
        UserDao userDao = context.getBean("userDaoImpl", UserDao.class);
        userDao.add();
    }

    @Test
    public void t_XMl() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = context.getBean("userDaoImpl", UserDao.class);
        userDao.add();
    }

}

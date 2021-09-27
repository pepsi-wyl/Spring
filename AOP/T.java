import dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import utils.ApplicationContextUtils;

/**
 * @author by wyl
 * @date 2021/9/25.12点42分
 */
public class T {

    @Test
    public void t1() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserDao userDao = context.getBean("userDaoImpl", UserDao.class);
        userDao.add();
    }

}

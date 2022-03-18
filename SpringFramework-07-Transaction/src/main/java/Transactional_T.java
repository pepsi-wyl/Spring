import org.junit.Test;
import org.springframework.context.ApplicationContext;
import service.UserService;
import utils.ApplicationContextUtils;

/**
 * @author by wyl
 * @date 2021/9/26.
 */
public class Transactional_T {

    @Test
    public void test(){
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        UserService userService = context.getBean("userService", UserService.class);
        userService.add_del();
    }

}

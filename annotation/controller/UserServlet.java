package controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import service.UserService;

import javax.annotation.Resource;

/**
 * @author by wyl
 * @date 2021/9/25.14点16分
 */

/**
 * @Controller Controller
 * <bean id="userServlet" class="controller.UserServlet"/>  注册bean
 */

//@Controller       //默认为类名小写
@Controller(value = "userServlet")  //设定value值

@Scope("singleton")

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class UserServlet {

    /**
     * J2EE原生注解   按照类型(byName)装配依赖对象
     * @Resource
     * @Resource(name = "xxx")     = @Autowired+@Qualifier(value = "xxx")
     */
    @Resource(name = "userServiceImpl")
    private UserService userService;

    /**
     * 调用Service方法
     */
    public void test() {
        userService.test();
    }
}

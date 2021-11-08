import org.junit.Test;
import org.springframework.context.ApplicationContext;
import pojo.People;
import utils.ApplicationContextUtils;

/**
 * @author by wyl
 * @date 2021/9/25.09点57分
 */
public class T {

    @Test
    public void t_1() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        People people = context.getBean("people", People.class);
        people.getCat().fun();
        people.getDog().fun();
    }

    @Test
    public void t_2() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext("annotation");
        People people = context.getBean("people", People.class);
        people.getCat().fun();
        people.getDog().fun();
        System.out.println(people);
    }

}

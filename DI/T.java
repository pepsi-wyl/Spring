import org.junit.Test;
import org.springframework.context.ApplicationContext;
import pojo.Person;
import pojo.Student;
import pojo.User;
import utils.ApplicationContextUtils;

import java.util.Arrays;

/**
 * @author by wyl
 * @date 2021/9/24.19点51分
 */
public class T {

    @Test
    public void DI_T() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        Student student = (Student) context.getBean("student");
        System.out.println(student.getName());
        System.out.println(student.getAddress());
        System.out.println(Arrays.asList(student.getBooks()));
        student.getHobbies().forEach((v) -> System.out.println(v));
        student.getCard().forEach((k, v) -> System.out.println(k + "==" + v));
        student.getGames().forEach((v) -> System.out.println(v));
        System.out.println(student.getWife());
        System.out.println(student.getInfo());
    }

    /**
     * 构造器注入
     */
    @Test
    public void constructor() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
//        context.getBean("user无参构造");
        User user1 = (User) context.getBean("user_2");
        System.out.println(user1);
        User user2 = (User) context.getBean("user_2");
        System.out.println(user1 == user2);     //相当于在加载配置文件时候就已经初始化对象成功    并放入容器中
    }

    /**
     * 特殊注入
     */
    @Test
    public void P_C() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        Person person_p = (Person) context.getBean("person_P");
        System.out.println(person_p);
        Person person_C = (Person) context.getBean("person_C");
        System.out.println(person_C);
    }

}

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import pojo.Address;
import pojo.Person;
import pojo.Student;
import pojo.User;
import utils.ApplicationContextUtils;

import java.util.Arrays;

/**
 * @author by wyl
 * @date 2021/11/5.09点57分
 */
public class T {
    /**
     * FactoryBean
     */
    @Test
    public void FactoryBean_T() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        System.out.println(context.getBean("myBean", Address.class));
    }

    /**
     * 构造器注入
     */
    @Test
    public void constructor() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();     //在加载配置文件时候就已经载入对象

//        User user = (User) context.getBean("user_无参构造");
//        System.out.println(user);

        User user1 = (User) context.getBean("user_有参构造");
        System.out.println(user1);
        User user2 = (User) context.getBean("user_有参构造");
        System.out.println(user1 == user2);     //相当于在加载配置文件时候就已经初始化对象成功    并放入容器中

    }

    @Test
    public void DI_T() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();

        Address address = (Address) context.getBean("address");
        System.out.println(address);

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

    /**
     * scope 单例模式 原型模式  Bean的声明周期
     */
    @Test
    public void scope() {
        ApplicationContext context = ApplicationContextUtils.getApplicationContext();
        Person person_p1 = (Person) context.getBean("person_P");
        Person person_p2 = (Person) context.getBean("person_P");
        System.out.println(person_p1 == person_p2);
        Person person_C1 = (Person) context.getBean("person_C");
        Person person_C2 = (Person) context.getBean("person_C");
        System.out.println(person_C1 == person_C2);
    }
}


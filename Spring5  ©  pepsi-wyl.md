# [Spring5](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/overview.html#overview-spring)简介    
## 简介

- Spring: 春天    
- Spring框架雏形 interface21 框架
- 响应于早期[J2EE](https://en.wikipedia.org/wiki/Java_Platform,_Enterprise_Edition)规范的复杂性，2003 年Spring应运而生。大杂烩，支持整合框架。
- 创始人 RodJohnson 悉尼大学音乐学博士
- 开源免费，轻量级，无入侵框架
- 控制反转（IOC） 面向切面编程（AOP）
## 七大模块
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642759575605-05fe0079-9964-40fb-b4c5-a2893e6bd958.png#clientId=u16de25fd-bc45-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=434&id=u0bf2c778&margin=%5Bobject%20Object%5D&name=image.png&originHeight=434&originWidth=829&originalType=binary&ratio=1&rotation=0&showTitle=false&size=187369&status=done&style=none&taskId=u9291091e-f2d2-493c-93f8-dc0cf6142f9&title=&width=829)

1. Spring Core： Core封装包是框架的最基础部分，提供IOC和依赖注入特性。这里的基础概念是BeanFactory，它提供对Factory模式的经典实现来消除对程序性单例模式的需要，并真正地允许你从程序逻辑中分离出依赖关系和配置。
1. Spring Context: 构建于Core封装包基础上的 Context封装包，提供了一种框架式的对象访问方法，有些象JNDI注册器。Context封装包的特性得自于Beans封装包，并添加了对国际化（I18N）的支持（例如资源绑定），事件传播，资源装载的方式和Context的透明创建，比如说通过Servlet容器。
1. Spring DAO:  DAO (Data Access Object)提供了JDBC的抽象层，它可消除冗长的JDBC编码和解析数据库厂商特有的错误代码。 并且，JDBC封装包还提供了一种比编程性更好的声明性事务管理方法，不仅仅是实现了特定接口，而且对所有的POJOs（plain old Java objects）都适用。
1. Spring ORM: ORM 封装包提供了常用的“对象/关系”映射APIs的集成层。 其中包括JPA、JDO、Hibernate 和 iBatis 。利用ORM封装包，可以混合使用所有Spring提供的特性进行“对象/关系”映射，如前边提到的简单声明性事务管理。
1. Spring AOP: Spring的 AOP 封装包提供了符合AOP Alliance 规范的面向方面的编程实现，让你可以定义，例如方法拦截器（method-interceptors）和切点（pointcuts），从逻辑上讲，从而减弱代码的功能耦合，清晰的被分离开。而且，利用source-level的元数据功能，还可以将各种行为信息合并到你的代码中。
1. Spring Web: Spring中的 Web 包提供了基础的针对Web开发的集成特性，例如多方文件上传，利用Servlet listeners进行IOC容器初始化和针对Web的ApplicationContext。当与WebWork或Struts一起使用Spring时，这个包使Spring可与其他框架结合。
1. Spring Web MVC: Spring中的MVC封装包提供了Web应用的Model-View-Controller（MVC）实现。Spring的MVC框架并不是仅仅提供一种传统的实现，它提供了一种清晰的分离模型，在领域模型代码和Web Form之间。并且，还可以借助Spring框架的其他特性。
# 入门
## 安装Spring5 
[maven](https://mvnrepository.com/search?q=spring)安装   导入WebMVC包后  maven会自动导入一些相关的依赖包
```xml
<!-- https://mvnrepository.com/artifact/org.springframework/spring-webmvc -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-webmvc</artifactId>
    <version>5.3.14</version>
</dependency>
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642856014232-9f76b40c-381b-4f1c-a696-f47e99f75b55.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=147&id=u1673f886&margin=%5Bobject%20Object%5D&name=image.png&originHeight=147&originWidth=360&originalType=binary&ratio=1&rotation=0&showTitle=false&size=67700&status=done&style=none&taskId=ud1776f51-26f3-49df-aa7f-03aea1784a3&title=&width=360)
## 编写java类
```java
/**
 * @author by wyl
 * @date 2021/9/23.21点53分
 */

public class Hello {

    /**
     * 属性
     */
    private String str;

    /**
     * 构造器方法
     */
    public Hello() {
    }

    public Hello(String str) {
        this.str = str;
    }


    public String getStr() {
        return str;
    }

    /**
     * 依赖注入
     */
    public void setStr(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return "Hello{" +
                "str='" + str + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hello hello = (Hello) o;
        return Objects.equals(str, hello.str);
    }

    @Override
    public int hashCode() {
        return Objects.hash(str);
    }
}
```
## 编写applicationContext.xml配置类
```xml
<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">

    //  使用Spring来创建对象  托管对象
    <bean id="Hello" class="pojo.Hello" scope="singleton" name="helloWorld helloWorld1,helloWorld2;helloWorld3">
        <property name="str" value="HelloWorld!"/>
    </bean>
    
</beans>
```
## 编写SpringUtils类
```java
package util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author by wyl
 * @date 2021/9/24.20点49分
 */
public class SpringUtils {

    /**
     * xml方式获取Spring配置文件
     */
    //默认
    public static ApplicationContext getApplicationContext() {
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    //自定义
    public static ApplicationContext getApplicationContext(String springXmlName) {
        return new ClassPathXmlApplicationContext(springXmlName + ".xml");
    }

}
```
## 测试
```java
/**
 * SpringFramework-helloWorld   Test
 */
@Test
public void HelloWorld_T() 
  ApplicationContext context = SpringUtils.getApplicationContext("applicationContext");
  Hello hello = context.getBean("Hello", Hello.class);
  System.out.println(hello);
}
```
# IOC容器
## 本质
控制反转IoC(Inversion of Control)，是一种设计思想,通过描述（XML或注解）并通过第三方去生产或获取特定对象的方式 ,降低代码的耦合度.
在Spring中实现控制反转的是IoC容器，依赖注入DI(Dependency Injection)是实现IoC的一种方法，也有人认为DI只是IoC的另一种说法
没有IoC的程序中 , 我们使用面向对象编程 , 对象的创建与对象间的依赖关系完全硬编码在程序中，对象的创建由程序自己控制，控制反转后将对象的创建转移给第三方，所谓控制反转就是：获得依赖对象的方式反转了。
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642767096531-300c0edc-80d5-421d-93c1-24baa614e505.png#clientId=u16de25fd-bc45-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=210&id=ua9b6fc6d&margin=%5Bobject%20Object%5D&name=image.png&originHeight=210&originWidth=659&originalType=binary&ratio=1&rotation=0&showTitle=false&size=99427&status=done&style=none&taskId=ub13dcbf8-c2de-47d1-a239-af0ff93c9d5&title=&width=659)
## XML管理
### XML中的基本配置作用
#### Bean配置
```xml
    <!--
         Bean的配置
    id         bean的id标识符
    class      bean对象所对应的全现限（包名+类名）
    name       别名，更高级，可以同时取多个别名  ","   ";"  " " ......等  应用于SSH
    scope      bean的作用域   singleton 单例   prototype 原型  (Request Session)
    constructor-arg  构造器    
    property   相当于对象中的属性
    value      相当于对象中的属性的值
    ref        相当于对象中的属性的引用对象
    -->
    
    <bean id="Hello" class="pojo.Hello" scope="singleton" name="helloWorld helloWorld1,helloWorld2;helloWorld3">
        <property name="str" value="HelloWorld!"/>
    </bean>  
```
#### 别名
```xml
    <!--alias 起别名-->
    <alias name="Hello" alias="hello"/>  
```
#### import
```xml
    <!--
    import     导入配置文件
    导入其他的Spring配置文件  适合多个人开发一个项目 
    内容相同 会统一为一个
    -->
    <import resource="new.xml"/> 
```
### 获取XML配置
#### 两个接口

- BeanFactory :IOC容器基本实现,Spring内部的使用接口,不提供开发人员进行使用 

       加载配置文件时候不会创建对象,加载对象才创建对象

- ApplicationContext : BeanFactory的子接口,提供更多强大的功能,一般由开发人员使用

       加载配置文件时候创建对象
       ApplicationContext 的两个实现类: ClassPathXmlApplicationContext   相对路径
                                                             FileSystemXmlApplicationContext  绝对路径
#### ApplicationContextUtils
```java
/**
 * @author by wyl
 * @date 2021/9/24.19点46分
 */

public class ApplicationContextUtils {

   /**
    * xml方式获取Spring配置文件
    */
    //默认
    public static ApplicationContext getApplicationContext() {
        return new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    //自定义
    public static ApplicationContext getApplicationContext(String springXmlName) {
        return new ClassPathXmlApplicationContext(springXmlName + ".xml");
    }

}
```
### XML底层实现原理
#### 原理图
底层原理   XML解析  工厂模式   反射
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642824123811-5a40a698-2ba2-4319-b5a1-11b8192bcbfa.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=437&id=LGi0U&margin=%5Bobject%20Object%5D&name=image.png&originHeight=437&originWidth=1064&originalType=binary&ratio=1&rotation=0&showTitle=false&size=158589&status=done&style=none&taskId=u97ab929d-12be-4c3b-a484-f4103ecf9ac&title=&width=1064)
### XML模板
```java
<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xmlns:p="http://www.springframework.org/schema/p"
       xmlns:c="http://www.springframework.org/schema/c"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
">
    
<beans/>
```
## DI  依赖注入 Bean

- spring先利用无参或者有参构造创建对象，然后利用set注入进行注入属性
- spring容器中的对象 默认为单例模式
### 构造器注入
```java
/**
 * @author by wyl
 * @date 2021/9/24.20点28分
 */

@ToString
public class User {

    private String name;

    public User() {
        System.out.println("User无参构造!");
    }

    public User(String name) {
        this.name = name;
        System.out.println("User有参构造!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

```
#### 无参构造
创建对象操作   Spring默认使用无参构造创建对象
```xml
<!--无参构造-->
<bean id="user" class="pojo.User" name="user_无参构造"/>      
```
```java
// 在加载配置文件时候就已经载入对象  并放入容器中 (由于使用ApplicationContext)
ApplicationContext context = ApplicationContextUtils.getApplicationContext();     
User user =context.getBean("user_无参构造",user.class);
System.out.println(user);
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642819802923-3df89abd-e29b-44af-9daa-59a3607d61e9.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=77&id=ucefeb70c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=77&originWidth=263&originalType=binary&ratio=1&rotation=0&showTitle=false&size=29807&status=done&style=none&taskId=ue88cacfd-a299-42df-bd31-63d7734504c&title=&width=263)
#### 有参构造
创建对象操作   Spring可以使用有参构造创建对象  顺便注入属性
setter注入是在有参构造注入之后
```xml
<!--name index type三种类型的有参构造-->
    
<!-- 有参构造 name   常用  -->
<bean id="user" class="pojo.User" name="user_有参构造" scope="singleton">
     <property name="name" value="zha"></property>    // set属性注入在构造器注入之后
     <constructor-arg name="name" value="zhazha"/>
</bean>

<!--有参构造 index-->
<bean id="user" class="pojo.User" name="user_有参构造">
     <constructor-arg index="0" value="zhazha"/>     // index 0
</bean>

<!--有参构造 type 不建议使用  全类名 -->	
<bean id="user" class="pojo.User" name="user_有参构造">
      <constructor-arg type="java.lang.String" value="zhazha"/>  // 必须使用全类名
</bean> 
```
```java
// 在加载配置文件时候就已经载入对象  并放入容器中
ApplicationContext context = ApplicationContextUtils.getApplicationContext();
User user = context.getBean("user_有参构造",User.class);
System.out.println(user);
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642819764892-3d5f686e-a34c-4ffe-9bdd-4f4b08ffec01.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=71&id=u49828c63&margin=%5Bobject%20Object%5D&name=image.png&originHeight=71&originWidth=268&originalType=binary&ratio=1&rotation=0&showTitle=false&size=28225&status=done&style=none&taskId=u7977752e-edd8-434f-8f91-d3de7d74472&title=&width=268)
### scope 作用域
Bean的作用域   托管对象的方式
#### 6种方式
| **Scope** | **Description** |
| --- | --- |
| [singleton](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-singleton) | (默认)将每个 Spring IoC 容器的单个 bean 定义范围限定为单个对象实例。 |
| [prototype](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-prototype) | 将单个 bean 定义的作用域限定为任意数量的对象实例。 |
| [request](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-request) | 将单个 bean 定义的范围限定为单个 HTTP 请求的生命周期。也就是说，每个 HTTP 请求都有一个在单个 bean 定义后面创建的 bean 实例。仅在可感知网络的 Spring ApplicationContext中有效。 |
| [session](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-session) | 将单个 bean 定义的范围限定为 HTTP Session的生命周期。仅在可感知网络的 Spring ApplicationContext上下文中有效。 |
| [application](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/core.html#beans-factory-scopes-application) | 将单个 bean 定义的范围限定为ServletContext的生命周期。仅在可感知网络的 Spring ApplicationContext上下文中有效。 |
| [websocket](https://www.docs4dev.com/docs/zh/spring-framework/5.1.3.RELEASE/reference/web.html#websocket-stomp-websocket-scope) | 将单个 bean 定义的范围限定为WebSocket的生命周期。仅在可感知网络的 Spring ApplicationContext上下文中有效。 |

#### 常见2种
单例模式 singleton  Spring默认机制  
（加载配置文件时候就创建对象  每次从容器中get的时候，都是一个对象）
```xml
<bean id="user_2" class="pojo.User" name="user_有参构造" scope="singleton">
   <property name="name" value="zha"></property>
   <constructor-arg name="name" value="zhazha"/>
</bean>
```
```java
ApplicationContext context = ApplicationContextUtils.getApplicationContext();
User user1 =  context.getBean("user_有参构造",User.class);
User user2 =  context.getBean("user_有参构造",User.class);
System.out.println(user1 == user2); 
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642819934777-eb5cf3f3-2ce9-4d3c-b5b0-3e116e88b680.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=50&id=u725c5821&margin=%5Bobject%20Object%5D&name=image.png&originHeight=50&originWidth=196&originalType=binary&ratio=1&rotation=0&showTitle=false&size=13818&status=done&style=none&taskId=u59399f08-2d1d-44b8-9c1d-896655e61a8&title=&width=196)
原型模式  prototype
（在getBean时候才创建对象  每次从容器中get的时候，都会产生新对象）
```xml
<bean id="user_2" class="pojo.User" name="user_有参构造" scope="prototype">
   <property name="name" value="zha"></property>
   <constructor-arg name="name" value="zhazha"/>
</bean>
```
```java
ApplicationContext context = ApplicationContextUtils.getApplicationContext();
User user1 =  context.getBean("user_有参构造",User.class);
User user2 =  context.getBean("user_有参构造",User.class);
System.out.println(user1 == user2); 
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642819960655-05b6f80e-b031-4d20-88ef-cd4fe805d7d4.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=102&id=uf5f6a1c8&margin=%5Bobject%20Object%5D&name=image.png&originHeight=102&originWidth=288&originalType=binary&ratio=1&rotation=0&showTitle=false&size=40853&status=done&style=none&taskId=u6214c14a-6f6d-46c1-850b-ab2b649111a&title=&width=288)
### Setter注入
```java
import lombok.*;
import java.util.*;

/**
 * @author by wyl
 * @date 2021/9/24.19点51分
 */

/**
 * lombok生成 java Bean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Student {
    private String name;                //name ---  value
    private Address address;            //name ---  ref  外部Bean
    private String[] books;             //name ---> array ---> value
    private List<String> hobbies;       //name ---> list  ---> value
    private Map<String, String> card;   //name ---> map   ---> entry --- value
    private Set<String> games;          //name ---> set   ---> value
    private String wife;                //name ---> null
    private Properties info;            //name ---> props ---> prop
}
```
```java
import lombok.*;

/**
 * @author by wyl
 * @date 2021/9/24.19点49分
 */

/**
 * lombok生成 java Bean
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Address {
    private String address;
}
```
#### 基本常见注入
```xml
<bean id="Student" class="pojo.Student" name="student" scope="singleton">

      <!--属性注入-->
      <property name="name" value="zhazha"/>

      <!--外部Bean注入  ref注入-->
      <property name="address" ref="address"/>

      <!--内部Bean注入  不常用-->
      <property name="address">
          <bean id="Address" class="pojo.Address" name="address">
              <property name="address" value="河南省安阳市"/>
          </bean>
      </property>
      
</bean>
```
#### NULL注入
```xml
<bean id="Student" class="pojo.Student" name="student" scope="singleton">
      <!--Null注入-->
      <!--  <property name="wife" value="">   设置为空串-->
      <property name="wife">
          <null/>  // 添加 NULL 标签
      </property>
</bean>
```
#### CDATA 特殊字符注入
```xml
<!--property属性注入  CDATA 特殊字符注入-->
<bean id="Address" class="pojo.Address" name="address" scope="singleton">
    <property name="address">
        <value><![CDATA[<<河南省安阳市>>]]></value>
    </property>
</bean>
```
#### property注入
```xml
<bean id="Student" class="pojo.Student" name="student" scope="singleton">    
     <!--property注入-->
     <property name="info">
         <props>
             <prop key="driver">com.mysql.cj.jdbc.Driver</prop>
             <prop key="user">root</prop>
             <prop key="password">123456</prop>
             <prop key="url">jdbc:mysql://localhost:3306/jdbc</prop>
          </props>
     </property>
</bean>
```
#### 数组集合注入
```xml
<bean id="Student" class="pojo.Student" name="student" scope="singleton">  
      <!--数组注入-->
      <property name="books">
          <array>
              <value>西游记</value>
              <value>红楼梦</value>
              <value>水浒传</value>
              <value>三国演变</value>
          </array>
      </property>

      <!--List注入-->
      <property name="hobbies">
          <list>
              <value>java</value>
              <value>C++</value>
              <value>Mysql</value>
          </list>
      </property>

      <!--Map注入-->
      <property name="card">
          <map>
              <entry key="学号" value="2015105456"/>
              <entry key="电话" value="13673330837"/>
          </map>
      </property>

      <!--Set注入-->
      <property name="games">
          <set>
              <value>跑跑卡丁车</value>
              <value>GTA5</value>
          </set>
      </property> 
</bean>
```
#### 数组集合中存储对象注入
```xml
<!--注入List 对象-->
<property name="list">
     <ref bean="Address"></ref>
</property>
```
#### 数组集合注入代码拆分
```xml
xmlns:util="http://www.springframework.org/schema/c"
```
```xml
<util:list id="hobbies">
      <value>java</value>
      <value>C++</value>
      <value>Mysql</value>
</util:list>

<bean id="Student" class="pojo.Student" name="student" scope="singleton">
      <!--list重复使用-->
      <property name="hobbies" ref="hobbies"/>
</bean>
```
### PC名称空间注入

- C名称空间注入  构造器注入
- P名称空间注入  setter注入
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Person {
    private String name;
    private int age;
}
```
#### C名称空间注入 (构造器)
在头文件中加入约束文件
```xml
xmlns:c="http://www.springframework.org/schema/c"
```
使用
```xml
<bean id="Person_C" class="pojo.Person" name="person_c" c:name="pepsi-wyl" c:age="20"/>
```
```java
ApplicationContext context = ApplicationContextUtils.getApplicationContext();
Person person_C = context.getBean("person_c", Person.class);
System.out.println(person_C);
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642837064369-5b757061-cfdc-4207-acbc-90023217427f.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=28&id=u752d937c&margin=%5Bobject%20Object%5D&name=image.png&originHeight=28&originWidth=271&originalType=binary&ratio=1&rotation=0&showTitle=false&size=13049&status=done&style=none&taskId=u0917be45-1a3c-4dcc-90c7-fc8d3ce5b4c&title=&width=271)
#### P名称空间注入 (setter)
在头文件中加入约束文件
```xml
xmlns:p="http://www.springframework.org/schema/p"
```
使用
```xml
<bean id="Person_P" class="pojo.Person" name="person_p" p:name="pepsi-wyl" p:age="20"/>
```
```java
ApplicationContext context = ApplicationContextUtils.getApplicationContext();
Person person_p = (Person) context.getBean("person_p");
System.out.println(person_p);
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642837067122-8756d087-2b97-45ff-b747-8a04a665464b.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=28&id=ue519c98f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=28&originWidth=271&originalType=binary&ratio=1&rotation=0&showTitle=false&size=13049&status=done&style=none&taskId=ubc8b83d3-078a-4f39-b965-a1a98bce4ce&title=&width=271)
### 外部属性文件注入
#### Mysql.properties配置文件引入
```properties
mysql.driverClassName=com.mysql.cj.jdbc.Driver
mysql.username=root
mysql.password=bsy8023.00
mysql.url=jdbc:mysql://localhost:3306/mybatis?useSSL=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&rewriteBatchedStatements=true
```
引入context命名空间
```xml
<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
">
```

```xml
<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd">


    <!--引入外部文件-->
    <context:property-placeholder location="classpath:mysql.properties"/>

    <!--配置数据源-->
    <beans>
        <bean id="dateSource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <property name="driverClassName"
                      value="${mysql.driverClassName}"/>
            <property name="url"
                      value="${mysql.url}"/>
            <property name="username"
                      value="${mysql.username}"/>
            <property name="password"
                      value="${mysql.password}"/>
        </bean>
    </beans>

</beans>
```
## FactoryBean
Spring中有2种Bean 

- 普通Bean  配置文件种定义Bean的类型就是返回类型
- 工厂Bean  配置文件种定义Bean的类型可以和返回类型不一致
### 简单使用
```java
// 实现FactoryBean接口
public class MyBean implements FactoryBean<Address> {

    // 重写方法  返回对象
    @Override
    public Address getObject() throws Exception {
        return new Address("安阳市");
    }
    
    // 重写方法 返回对象类型
    @Override
    public Class<?> getObjectType() {
        return Address.class;
    }

    @Override
    public boolean isSingleton() {
        return FactoryBean.super.isSingleton();
    }
}
```
```xml
<!--FactoryBean-->
<bean id="MyBean" class="FactoryBean.MyBean" name="myBean"/>
```
```java
/**
 * FactoryBean
 */
@Test
public void FactoryBean_T() {
    ApplicationContext context = ApplicationContextUtils.getApplicationContext();
    System.out.println(context.getBean("myBean", Address.class));
}
```
## 自动装配
### xml
#### 实体类
```java
public class Dog {
    public void fun(){
        System.out.println("wang~");
    }
}

public class Cat {
    public void fun() {
        System.out.println("miao~");
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class People {
    private Cat cat;
    private Dog dog;
    private String name;
}
```
#### xml配置
```xml
<beans>
<!--
    autowire="byName"  
会自动在容器上下文中查找，和自己对象set方法后面的值对应的       
保证所有bean的id唯一并且这个bean需要和自动注入的属性的set方法的值-致!
        
    autowire="byType"  
会自动在容器上下文中查找，和自己对象属性类型相同的bean         
保证所有bean的class唯一并且这个bean需要和自动注入的属性的类型-致!
-->

        <!--  byName通常使用-->
        <bean id="cat" class="pojo.Cat"/>
        <bean id="dog" class="pojo.Dog"/>
        <bean id="people" class="pojo.People" autowire="byName">
            <property name="name" value="zhazha"/>
        </bean>

        <!--  byType-->
        <bean class="pojo.Cat"/>
        <bean class="pojo.Dog"/>
        <bean id="people" class="pojo.People" autowire="byType">
            <property name="name" value="zhazha"/>
        </bean>
</beans>
```
#### 测试
```java
@Test
public void t_1() {
   ApplicationContext context = ApplicationContextUtils.getApplicationContext();
   People people = context.getBean("people", People.class);
   people.getCat().fun();
   people.getDog().fun();
}
```
### 注解
#### 实体类 注解配置
```java
@Component              // 注册组件
public class Cat {
    public void fun() {
        System.out.println("miao~");
    }
}

@Component            // 注册组件
public class Dog {
    public void fun(){
        System.out.println("wang~");
    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Component(value = "people")   // 注册组件
public class People {
  
    @Autowired(required = false)
    @Qualifier(value = "cat")
    private Cat cat;          // 注入cat对象

    @Resource(name = "dog")
    private Dog dog;          // 注入dog对象

    @Value("zhazha")
    private String name;      // 注入name值
  
}
```
#### xml配置

- 引入 context 命名空间 
- 开启注解支持
```xml
<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
">

    <!--开启注解支持-->
    <context:annotation-config/>
    <!--扫描注解包-->
    <context:component-scan base-package="pojo"/>

</beans>
```
#### 测试
```java
@Test
public void t_2() {
    ApplicationContext context = ApplicationContextUtils.getApplicationContext("annotation");
    People people = context.getBean("people", People.class);
    people.getCat().fun();
    people.getDog().fun();
    System.out.println(people);
}
```
## 注解开发

- XML可以适用任何场景 ，结构清晰，维护方便
- 注解不是自己提供的类使用不了，开发简单方便

- xml管理Bean
- 注解完成属性注入
### 导入AOP依赖
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642856035255-bb93b191-f346-4834-b0c2-303e27106e3f.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=147&id=u9884f145&margin=%5Bobject%20Object%5D&name=image.png&originHeight=147&originWidth=360&originalType=binary&ratio=1&rotation=0&showTitle=false&size=67700&status=done&style=none&taskId=u505aef22-679c-41f9-aab1-8f5d45e614d&title=&width=360)
### 扫描组件XML
```xml
<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd">
    
    <!--注解驱动注册-->
    <context:annotation-config/>

    <!--扫描单个注解包-->
    <context:component-scan base-package="pojo"/>
    <context:component-scan base-package="mapper"/>
    <context:component-scan base-package="service"/>
    <context:component-scan base-package="controller"/>
    
    <!--扫描多个包 ","   ";"  " "隔开-->
    <context:component-scan base-package="pojo,mapper,service,controller"/>
    
</beans>   
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642856838692-895bf649-c20b-479b-9eea-a138a044d14c.png#clientId=uf95e7f1e-c322-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=168&id=ud6b18e45&margin=%5Bobject%20Object%5D&name=image.png&originHeight=168&originWidth=708&originalType=binary&ratio=1&rotation=0&showTitle=false&size=172662&status=done&style=none&taskId=uff7462d7-a202-4e3b-b06a-e07a10d09ac&title=&width=708)
```xml
<!--use-default-filters="false"  表示自定义扫描组件-->
    
<!--pojo包中  扫描Component 不扫描Service -->    
<context:component-scan base-package="pojo" use-default-filters="false">
    <!--包含-->
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Component"/>
    <!--不包含-->
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Service"/>
</context:component-scan>

<!--mapper包中  扫描Repository 不扫描Component -->
<context:component-scan base-package="mapper" use-default-filters="false">
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Component"/>
</context:component-scan>

<!--service包中  扫描Service 不扫描Repository -->
<context:component-scan base-package="service" use-default-filters="false">
    <context:include-filter type="annotation" expression="org.springframework.stereotype.Service"/>
    <context:exclude-filter type="annotation" expression="org.springframework.stereotype.Repository"/>
</context:component-scan>
```
### 创建对象
#### 注册组件
```java
// 创建对象的值默认为首字母小写
@Component()      // 任意层
/* 三个衍生注解 */
@Repository()     // DAO层
@Service()        // Service层
@Controller()     // Controller层
```
```java
// value属性 可以自定义名称
@Component(value = "user")  
/* 三个衍生注解 */
@Repository(value = "userDaoImpl")    //value为userDaoImpl
@Service(value = "userServiceImpl")   //value为userService
@Controller(value = "userServlet")    //value为userServlet
```
注意：创建对象的值默认为首字母小写    value属性  可以自定义名称
#### 作用域
```java
@Scope("singleton")  //singleton 单例模式 (默认)  prototype 原型模式
```
#### 实例
```java
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

/**
 * @Component  ------>  @Repository(dao)  @Service(Service)   @Controller(controller)
 * 相当于<bean id="user" class="pojo.User"/>  注册bean
 */

// 注册组件
@Component(value = "user")

// 作用域
@Scope("singleton")   //singleton 单例模式   prototype 原型模式

public class User {
    private String name;
}
```
### 属性注入
#### **@Autowired @Qualifier**
Srping注解

- @Autowired按照类型(byType)装配 可以是否允许null值
- 想使用按照名称装配需要@Qualifier(value="XXXXXX")
- 不需要编写setter方法
```java
// 按照类型(byType)装配
@Autowired
@Autowired(required = false)   允许null值
@Autowired(required = true)    不允许null值
```
```java
// 按照名称(byName)装配  不能单独使用,结合@Autowired使用 
@Qualifier(value="XXXXXX")
```
```java
@Autowired(required = false)
@Qualifier(value = "cat")
private Cat cat;

@Autowired(required = false)
public UserServiceImpl(@Qualifier(value = "userDaoImpl") UserDao userDao) {
    this.userDao = userDao;
}
```
#### **@Resource  **
J2EE原生注解

- 如果有指定name属性 则按照ByName进行装配
- 不成功其次默认的ByName装配 
- 不成功还可以ByType装配
- 不成功则抛出异常
```java
@Resource
@Resource(name = "dog")  ------> @Autowired + @Qualifier(value = "dog")
```
```java
@Resource(name = "dog")
private Dog dog;
```
#### @Value
```java
@Value  //注入值  (非对象 普通类型属性)
```
```java
// 可以不用提供set方法，直接在直接名上添加@value("值")
@Value("zhazha")
private String name;

// 如果提供了set方法，在set方法上添加@value("值")
@Value("zhazha")
public void setName(String name) {
  this.name = name;
}
```
#### @Nullable
可以为空值
```java
@Nullable
属性  字段可以为空
方法上  方法返回值可以为空
方法参数里面  方法参数可以为空     
```
```java
// 字段可以为空
@Nullable
private String name;

// 方法返回值可以为空
@Nullable
public String getName() {
    return this.name;
}

// 方法参数可以为空
public void setName(@Nullable String name) {
     this.name = name;
}
```
### 完全注解开发
#### 配置config类
```java
@Import(config.class)      //引入其他配置文件

//扫描注解包
@ComponentScan(basePackages = {"pojo", "mapper", "service", "controller"}) 

@Configuration           // 作为配置类 替代XML配置文件  
@Scope("singleton")      // 配置类的作用域
public class applicationContext {

}
```
```java
// 用于注册组件 可以直接利用注解代替 
// @Bean注解可以把第三方库中的类实例交给spring管理
@Configuration
public class config {

    @Bean
    public User User() {
        return new User();
    }

    @Bean
    public UserDaoImpl UserDaoImpl() {
        return new UserDaoImpl();
    }

    @Bean
    public UserServiceImpl userServiceImpl() {
        return new UserServiceImpl();
    }

    @Bean
    public UserServlet UserServlet() {
        return new UserServlet();
    }

}
```
#### 测试
AnnotationConfigApplicationContext
```java
// 加载ConfigJava配置类
AnnotationConfigApplicationContext context = 
    new AnnotationConfigApplicationContext(applicationContext.class);

User user = context.getBean("user", User.class);
System.out.println(user);
```
# AOP面向切面编程
## 简介

- 面向切面(方面)编程,利用AOP可以对业务逻辑的各个部分进行隔离，从而使得业务逻辑各部分之间的耦合度降低，提高程序的可重用性，同时提高了开发效率。
- 通俗描述：不修改源代码方式，在 主干功能里面添加新功能

![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642927263227-bf27621b-c05f-4ee5-96cb-c8ccd7854ee3.png#clientId=u243e1697-22a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=595&id=uddaf3455&margin=%5Bobject%20Object%5D&name=image.png&originHeight=595&originWidth=1315&originalType=binary&ratio=1&rotation=0&showTitle=false&size=207269&status=done&style=none&taskId=u34b94a2f-3de9-4de5-b54e-986de52e50e&title=&width=1315)
## 动态代理
### 原理图
创建接口实现类代理对象，增强类的方法
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642927534998-b815a57b-d530-4a8e-ab40-2ee0a9afe09d.png#clientId=u243e1697-22a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=325&id=uc9c117be&margin=%5Bobject%20Object%5D&name=image.png&originHeight=325&originWidth=1221&originalType=binary&ratio=1&rotation=0&showTitle=false&size=100054&status=done&style=none&taskId=ua9c8d2ea-0293-450b-8d18-1448dc59159&title=&width=1221)
创建子类的代理对象，增强类的方法
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642927674189-125646dc-e78f-4827-a15f-4c219e042699.png#clientId=u243e1697-22a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=432&id=ueee8120f&margin=%5Bobject%20Object%5D&name=image.png&originHeight=432&originWidth=1166&originalType=binary&ratio=1&rotation=0&showTitle=false&size=119049&status=done&style=none&taskId=u1acf3ebd-5608-4288-84b6-362d58f6ff2&title=&width=1166)
### 代码
```java
import java.lang.reflect.Proxy;
/**
 * @author by pepsi-wyl
 * @date 2022-01-23 16:58
 */

class ProxyInvocationHandler {
    //生成代理类
    public <T> T getProxy(Class<T> t, Object implClass) {   // 实现类
        // newProxyInstance(
        // ClassLoader loader,     // 类加载器
        // Class<?>[] interfaces,  // 实现类的接口
        // InvocationHandler h     // InvocationHandler接口实例 invoke(Object proxy, Method method, Object[] args) 处理代理的实例
        // )
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), implClass.getClass().getInterfaces(),
                (proxy, method, args) -> {
                    System.out.println(method.getName() + "执行");
                    return method.invoke(implClass, args);
                }
        );
    }
}
```
```java
public static void main(String[] args) {
   UserDao proxy = new ProxyInvocationHandler().getProxy(UserDao.class, new UserDaoImpl());
   System.out.println(proxy.add(1, 2));
   System.out.println(proxy.update("10086"));
}
```
## AOP的操作术语
提供声明式事务，允许用户自定义切面
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642931991943-f21fd4a6-a306-4a53-ac56-53fb5a920018.png#clientId=u243e1697-22a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=212&id=u86dce20a&margin=%5Bobject%20Object%5D&name=image.png&originHeight=212&originWidth=632&originalType=binary&ratio=1&rotation=0&showTitle=false&size=116185&status=done&style=none&taskId=u46aeb0e7-bcbc-4397-92b9-c96936e4ea4&title=&width=632)
## ![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642932036188-842d3993-d0af-4b22-b04c-7ff27286a927.png#clientId=u243e1697-22a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=311&id=uf09bb96b&margin=%5Bobject%20Object%5D&name=image.png&originHeight=311&originWidth=542&originalType=binary&ratio=1&rotation=0&showTitle=false&size=98401&status=done&style=none&taskId=u305b3842-9f07-446e-81a9-c8a13dc2c70&title=&width=542)
```xml
                  Spring 框架一般基于AspectJ实现AOP操作
连接点:类里面可以被增强的方法
切入点:实际被真正增强的方法
通知: 实际增强的逻辑部分
      前置通知  后置通知  环绕通知  异常通知  最终通知
切面:把通知应用的切入点的过程

切入点表达式:
  execution([权限修饰符][返回类型][类全路径][方法名称]([参数列表]))
  * 全路径.类名.方法名(..)   * 全路径.类名.*(..)  * 全路径.*.*(..)

```
## 安装aop和aspectj
maven安装
```xml
<!--
aop Spring依赖
-->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-aop</artifactId>
    <version>5.3.14</version>
</dependency>

<!--
aspectj不是Spring的组成部分 是单独的一部分，与Sping组合进行AOP操作
-->
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjweaver</artifactId>
    <version>1.9.7</version>
    <scope>runtime</scope>
</dependency>
<dependency>
    <groupId>org.aspectj</groupId>
    <artifactId>aspectjrt</artifactId>
    <version>1.9.7</version>
</dependency>
```
## XML实现
### 接口实现 
#### 增强类
```java
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Component
@Scope("singleton")
public class BeforeLog implements MethodBeforeAdvice {
    /**
     * @param method   要执行的目标对象的方法
     * @param args     方法的参数
     * @param target   目标对象
     * @throws Throwable
     */
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[DEBUG]" + target.getClass().getName() + "的" + method.getName() + "执行");
    }
}
```
```java
import org.springframework.aop.AfterReturningAdvice;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

@Component
@Scope("singleton")
public class AfterLog implements AfterReturningAdvice {
    /**
     * @param returnValue 返回值
     * @param method      要执行的目标对象的方法
     * @param args        方法的参数
     * @param target      目标对象
     * @throws Throwable
     */
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("[DEBUG]" + target.getClass().getName() + "的" + method.getName() + "执行完毕" + (returnValue == null ? "" : "返回值为" + returnValue));
    }
}
```
#### xml配置增强
```xml
<!--扫描注解-->
<context:component-scan base-package="mapper Log"/>

<!--SpringAPI实现-->
<aop:config>
    <!--切入点 expression表达式 execution(要执行的位置 * * * * * )-->
    <aop:pointcut id="pointCut" expression="execution(* mapper.UserDaoImpl.*(..))"/>
    <!--执行环绕增强  通知-->
    <aop:advisor advice-ref="beforeLog" pointcut-ref="pointCut"/>
    <aop:advisor advice-ref="afterLog" pointcut-ref="pointCut"/>
</aop:config>
```
### 自定义实现 
#### 增强类
```java
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component             //托管到Spring中
@Scope("singleton")    //Bean作用域
public class diy {
    public void before() {
        System.out.println("before!");
    }
  
    public void after() {
        System.out.println("after!");
    }
}

```
#### xml配置增强
```xml
<!--扫描注解-->
<context:component-scan base-package="mapper diy"/>

<!--diy自定义类实现-->
<aop:config>
    <!-- 切面   重点 类-->
    <aop:aspect ref="diy">
        <!--切入点 expression表达式 execution(要执行的位置 * * * * * )-->
        <aop:pointcut id="point" expression="execution(* mapper.UserDaoImpl.*(..))"/>
        <!--通知-->
        <aop:after method="after" pointcut-ref="point"/>
        <aop:before method="before" pointcut-ref="point"/>
    </aop:aspect>
</aop:config>
```
## 注解实现 （经常使用 需要aspectj包）
### 增强类
```java
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 执行顺序  
 * 环绕前  before  方法体  afterReturning/afterThrowing  after  环绕后
 */

// 标注此类是切面类 开启Aspect 生产代理对象
@Aspect

// 多个类对同一个方法增强
// 设置该类对方法增强的优先级,数字越小优先级越高
@Order(1)  

@Component             //托管到Spring中
@Scope("singleton")    //Bean作用域
public class diy {

   /**
    * @Pointcut (execution表达式) [公共切点]
    * 抽取公共的切入点
    */
    @Pointcut("execution(* mapper.UserDaoImpl.*(..))")
    public void pointcutPublic() {
    }

   /**
    * 前置通知
    */
    @Before("pointcutPublic()")          //引用公共切入点
    public void before() {
        System.out.println("before!");
    }

   /**
    * 异常通知
    */
    @AfterThrowing("execution(* mapper.UserDaoImpl.*(..))")
    public void afterThrowing() {
        System.out.println("afterThrowing!");
    }

   /**
    * 后置通知（返回通知）  异常出现不执行
    */
    @AfterReturning("execution(* mapper.UserDaoImpl.*(..))")
    public void afterReturning() {
        System.out.println("afterReturning!");
    }

   /**
    * 最终通知      异常出现也执行
    */
    @After("execution(* mapper.UserDaoImpl.*(..))")
    public void after() {
        System.out.println("after!");
    }

   /**
    * 环绕通知
    */
    @Around("execution(* mapper.UserDaoImpl.*(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("环绕前");
        point.proceed();    //相当于过滤
        System.out.println("环绕后");
    }
}

```
### 注解扫描
#### xml
```xml
<?xml version="1.0" encoding="utf-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
        http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd
">
    
    <!--扫描组件-->
    <context:component-scan base-package="mapper diy"/>
    
    <!--开启AspectJ AOP注解支持-->
    <aop:aspectj-autoproxy/>
    
</beans>   
```
#### java
```java
@ComponentScan(basePackages = {"mapper", "diy"})   //扫描注解包
@EnableAspectJAutoProxy(proxyTargetClass = true)   //开启AspectJ AOP注解支持

                                //配置生命周期
@Configuration                                     //表面此类是配置类
public class ConfigAOP {

}
```
### 测试
#### xml
```java
ApplicationContext context = ApplicationContextUtils.getApplicationContext();
UserDao userDao = context.getBean("userDaoImpl", UserDao.class);
userDao.add();
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642939859925-55950ecb-c727-4704-8469-24cd050d362b.png#clientId=u243e1697-22a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=142&id=ua9e8d918&margin=%5Bobject%20Object%5D&name=image.png&originHeight=142&originWidth=281&originalType=binary&ratio=1&rotation=0&showTitle=false&size=55438&status=done&style=none&taskId=u1a41a3c7-9ccb-4fe7-b761-73f6165ba4a&title=&width=281)
#### java
```java
AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigAOP.class);
UserDao userDao = context.getBean("userDaoImpl", UserDao.class);
userDao.add();
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1642939859925-55950ecb-c727-4704-8469-24cd050d362b.png#clientId=u243e1697-22a9-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=142&id=BesX1&margin=%5Bobject%20Object%5D&name=image.png&originHeight=142&originWidth=281&originalType=binary&ratio=1&rotation=0&showTitle=false&size=55438&status=done&style=none&taskId=u1a41a3c7-9ccb-4fe7-b761-73f6165ba4a&title=&width=281)
# 数据库操作
## JDBCTemplate
Spring框架对JDBC进行的封装
### 导入依赖
```xml
        <!--junit-jar包-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>

        <!--lombok jar依赖包-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
            <scope>provided</scope>
        </dependency>

        <!--mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.24</version>
        </dependency>
        
        <!--druid连接池驱动-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.6</version>
        </dependency>
        
        <!--SpringFramework-webmvc-jar 依赖包-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.10</version>
        </dependency>

        <!--SpringFramework-jdbc-jar 依赖包-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.3.10</version>
        </dependency>
        
        <!-- SpringTX事务依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-tx</artifactId>
            <version>5.3.10</version>
        </dependency>

        <!-- SpringAOP依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
    				<artifactId>spring-aop</artifactId>
    				<version>5.3.10</version>
				</dependency>

        <!--使用AOP织入 依赖 jar包 -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.7</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>1.9.7</version>
        </dependency>
```
### 配置数据源
mysql.properties
```properties
mysql.driverClassName=com.mysql.cj.jdbc.Driver
mysql.username=root
mysql.password=xxxxxxxx
mysql.url=jdbc:mysql://localhost:3306/mybatis?useSSL=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&rewriteBatchedStatements=true
```
### 配置XML文件
applicationContext.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd
">

    <!--开启注解支持-->
    <context:annotation-config/>
    <!--扫描注解-->
    <context:component-scan base-package="pojo dao service"/>

    <!--开启AspectJ AOP注解支持-->
    <aop:aspectj-autoproxy/>
  
    <!-- 引入数据库配置文件-->
    <context:property-placeholder location="classpath:mysql.properties"/>

    <beans>
      
        <!--使用Spring提供的JDBC:DriverManagerDataSource-->
        <bean id="dateSourceSpring" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <property name="driverClassName"
                      value="${mysql.driverClassName}"/>
            <property name="url"
                      value="${mysql.url}"/>
            <property name="username"
                      value="${mysql.username}"/>
            <property name="password"
                      value="${mysql.password}"/>
        </bean>

        <!--使用druid提供的DruidDataSource-->
        <bean id="dateSourceDruid" class="com.alibaba.druid.pool.DruidDataSource">
            <property name="driverClassName"
                      value="${mysql.driverClassName}"/>
            <property name="url"
                      value="${mysql.url}"/>
            <property name="username"
                      value="${mysql.username}"/>
            <property name="password"
                      value="${mysql.password}"/>
        </bean>

        <!--
        配置JDBC模板
        -->
        <!--注入JDBCTemplate 简单JDBC操作-->
        <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
            <property name="dataSource" ref="dateSourceSpring"/>
        </bean>
      
        <!--开启 Spring 的事务处理功能    创建事务管理器   Mybatis,JDBC使用DataSourceTransactionManager  -->
        <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
            <!--注入数据源-->
            <property name="dataSource" ref="dateSourceSpring"/>
        </bean>

      	<!--开启事务注解-->
      	<tx:annotation-driven transaction-manager="transactionManager"/>

    </beans>

</beans>
```
### 编写实体类
```java
import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode

@Component(value = "user")
@Scope("prototype")

public class User {
    private int id;
    private String name;
    private String pwd;
}
```
### 编写UserDao接口
```java
import pojo.User;
import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 11:16
 */

public interface UserDao {

    /**
     * 添加用户
     */
    int addUser(User user);

    /**
     * 通过ID删除用户
     */
    int deleteUserByID(int id);

    /**
     * 修改用户
     */
    int updateUser( User user);

    /**
     * 查询用户的个数
     */
    int queryCount();

    /**
     * 查询UserByID
     */
    User queryUserByID(int id);

    /**
     * 查询所有用户
     */
    List<User> queryUserList();

    /**
     * 批量添加
     */
    int[] addUserBatch(List<Object[]> batchArgs);

    /**
     * 批量修改
     */
    int[] updateUserBatch(List<Object[]> batchArgs);

    /**
     * 批量删除
     */
    int[] deleteUserBatch(List<Object[]> batchArgs);

}
```
### 编写UserService接口
```java
import pojo.User;
import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 11:16
 */

public interface UserService {

    /**
     * 添加用户
     */
    int addUser(User user);

    /**
     * 通过ID删除用户
     */
    int deleteUserByID(int id);

    /**
     * 修改用户
     */
    int updateUser( User user);

    /**
     * 查询用户的个数
     */
    int queryCount();

    /**
     * 查询UserByID
     */
    User queryUserByID(int id);

    /**
     * 查询所有用户
     */
    List<User> queryUserList();

    /**
     * 批量添加
     */
    int[] addUserBatch(List<Object[]> batchArgs);

    /**
     * 批量修改
     */
    int[] updateUserBatch(List<Object[]> batchArgs);

    /**
     * 批量删除
     */
    int[] deleteUserBatch(List<Object[]> batchArgs);
}
```
### 实现UserDao接口
```java
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pojo.User;
import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 11:16
 */

@Repository("userDaoImpl")
@Scope("singleton")
public class UserDaoImpl implements UserDao {

    /**
     * 注入jdbcTemplate 对象
     */
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(@Qualifier(value = "jdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 添加user对象
     */
    @Override
    public int addUser(User user) {
        return jdbcTemplate.update
                ("insert into mybatis.user value (?,?, ?)", user.getId(), user.getName(), user.getPwd());
    }

    /**
     * 删除user对象 ById
     */
    @Override
    public int deleteUserByID(int id) {
        return jdbcTemplate.update
                ("delete from mybatis.user where id=?", id);
    }

    /**
     * 修改user对象 ById
     */
    @Override
    public int updateUser(User user) {
        return jdbcTemplate.update
                ("update mybatis.user set name=?,pwd=? where id=?", user.getName(), user.getPwd(), user.getId());
    }

    /**
     * 查询UserCount
     */
    @Override
    public int queryCount() {
        return jdbcTemplate.queryForObject
                ("select count(*) from mybatis.user", Integer.class);
    }

    /**
     * 查询UserByID
     * RowMapper 返回不同数据类型 使这个接口里面实现类完成数据封装
     */
    @Override
    public User queryUserByID(int id) {
        return jdbcTemplate.queryForObject
                ("select * from mybatis.user where id=?", 
                 new BeanPropertyRowMapper<User>(User.class), id);
    }

    /**
     * 查询所有用户 List集合
     */
    @Override
    public List<User> queryUserList() {
        return jdbcTemplate.query
                ("select * from mybatis.user", 
                 new BeanPropertyRowMapper<User>(User.class));
    }

    /**
     * 批量添加
     */
    @Override
    public int[] addUserBatch(List<Object[]> batchArgs) {
        return jdbcTemplate.batchUpdate
                ("insert into mybatis.user value (?,?, ?)", batchArgs);
    }

    /**
     * 批量修改
     */
    @Override
    public int[] updateUserBatch(List<Object[]> batchArgs) {
        return jdbcTemplate.batchUpdate
                ("update mybatis.user set name=?,pwd=? where id=?", batchArgs);
    }

    /**
     * 批量删除
     */
    @Override
    public int[] deleteUserBatch(List<Object[]> batchArgs) {
        return jdbcTemplate.batchUpdate
                ("delete from mybatis.user where id=?", batchArgs);
    }

}
```
### 实现UserService接口
```java
import dao.UserDao;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import pojo.User;
import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 11:16
 */

@Transactional
        (
                propagation = Propagation.REQUIRED,
                isolation = Isolation.REPEATABLE_READ,
                timeout = 10,
                readOnly = false
        )       // 配置事务

@Service(value = "userServiceImpl")
@Scope("singleton")
public class UserServiceImpl implements UserService {

    /**
     * UserDao实现类对象
     */
    private final UserDao userDao;

    public UserServiceImpl(@Qualifier(value = "userDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * 添加user对象
     */
    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    /**
     * 删除user对象 ById
     */
    @Override
    public int deleteUserByID(int id) {
        return userDao.deleteUserByID(id);
    }

    /**
     * 修改user对象 ById
     */
    @Override
    public int updateUser(User user) {
        return userDao.updateUser(user);
    }

    /**
     * 查询UserCount
     */
    @Override
    public int queryCount() {
        return userDao.queryCount();
    }

    /**
     * 查询UserByID
     */
    @Override
    public User queryUserByID(int id) {
        return userDao.queryUserByID(id);
    }

    /**
     * 查询所有用户
     */
    @Override
    public List<User> queryUserList() {
        return userDao.queryUserList();
    }

    /**
     * 批量添加
     */
    @Override
    public int[] addUserBatch(List<Object[]> batchArgs) {
        return userDao.addUserBatch(batchArgs);
    }

    /**
     * 批量修改
     */
    @Override
    public int[] updateUserBatch(List<Object[]> batchArgs) {
        return userDao.updateUserBatch(batchArgs);
    }

    /**
     * 批量删除
     */
    @Override
    public int[] deleteUserBatch(List<Object[]> batchArgs) {
        return userDao.deleteUserBatch(batchArgs);
    }
}
```
### 测试代码
```java
public class T {

    /**
     * 添加用户
     */
    @Test
    public void addUser() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        User user = applicationContext.getBean("user", User.class);
        user.setId(20000);
        user.setName("zhazha");
        user.setPwd("888888");
        System.out.println(userService.addUser(user) > 0 ? "success" : "error");
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUserByID() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        System.out.println(userService.deleteUserByID(20000) > 0 ? "success" : "error");
    }

    /**
     * 修改用户
     */
    @Test
    public void updateUser() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        User user = applicationContext.getBean("user", User.class);
        user.setId(20000);
        user.setName("zha");
        user.setPwd("888888");
        System.out.println(userService.updateUser(user) > 0 ? "success" : "error");
    }

    /**
     * 查询用户个数
     */
    @Test
    public void queryCount() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        System.out.println(userService.queryCount());
    }

    /**
     * 通过ID查找用户
     */
    @Test
    public void queryUserByID() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        User user = userService.queryUserByID(4);
        System.out.println(user);
    }

    /**
     * 查找所有用户 List集合
     */
    @Test
    public void queryUserList() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
        List<User> userList = userService.queryUserList();
        userList.forEach(System.out::println);
    }

    /**
     * 批量添加
     */
    @Test
    public void addUserBatch() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);

        ArrayList<Object[]> batchArgs = new ArrayList<>();
        Object[] user1 = {1, "zhazha", "888888"};
        Object[] user2 = {2, "zhazha", "888888"};
        batchArgs.add(user1);
        batchArgs.add(user2);

        int[] ints = userService.addUserBatch(batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 批量修改
     */
    @Test
    public void updateUserBatch() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);

        ArrayList<Object[]> batchArgs = new ArrayList<>();
        Object[] user1 = {"zhazha", "999999", 1};
        Object[] user2 = {"zhazha", "999999", 2};
        batchArgs.add(user1);
        batchArgs.add(user2);

        int[] ints = userService.updateUserBatch(batchArgs);
        System.out.println(Arrays.toString(ints));
    }

    /**
     * 批量删除
     */
    @Test
    public void deleteUserBatch() {
        ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
        UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);

        ArrayList<Object[]> batchArgs = new ArrayList<>();
        Object[] user1 = {1};
        Object[] user2 = {2};
        batchArgs.add(user1);
        batchArgs.add(user2);

        int[] ints = userService.deleteUserBatch(batchArgs);
        System.out.println(Arrays.toString(ints));
    }
    
}
```
## Mybatis
Spring对Mybatis框架进行整合
### 导入依赖
```xml
        <!--junit-jar包-->
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>4.12</version>
        </dependency>

        <!--lombok jar依赖包-->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.12</version>
            <scope>provided</scope>
        </dependency>

        <!--log4j jar包-->
        <dependency>
            <groupId>log4j</groupId>
            <artifactId>log4j</artifactId>
            <version>1.2.17</version>
        </dependency>

        <!--mysql驱动-->
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.24</version>
        </dependency>

        <!--druid驱动-->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>druid</artifactId>
            <version>1.2.6</version>
        </dependency>

        <!--mybatis-jar包-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.4.6</version>
        </dependency>

        <!--mybatis-ehcache jar包-->
        <dependency>
            <groupId>org.mybatis.caches</groupId>
            <artifactId>mybatis-ehcache</artifactId>
            <version>1.2.1</version>
        </dependency>

        <!--Mybatis - Spring-->
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.6</version>
        </dependency>

        <!--SpringFramework-webmvc-jar 依赖包-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.3.10</version>
        </dependency>

        <!--SpringFramework-jdbc-jar 依赖包-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-jdbc</artifactId>
            <version>5.3.10</version>
        </dependency>

        <!-- SpringAOP依赖-->
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-aop</artifactId>
            <version>5.3.10</version>
        </dependency>

        <!--使用AOP织入 依赖 jar包 -->
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.7</version>
            <scope>runtime</scope>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjrt</artifactId>
            <version>1.9.7</version>
        </dependency>
```
### 配置数据源
mysql.properties
```properties
mysql.driverClassName=com.mysql.cj.jdbc.Driver
mysql.username=root
mysql.password=XXXXXX
mysql.url=jdbc:mysql://localhost:3306/mybatis?useSSL=true&useUnicode=true&characterEncoding=utf8&serverTimezone=UTC&rewriteBatchedStatements=true
```
### 配置Log4j
log4j.properties
```properties
#将等级为DEBUG的日志信息输出到console和file这两个目的地，console和file的定义在下面的代码
log4j.rootLogger=DEBUG,console,file

#控制台输出的相关设置
log4j.appender.console = org.apache.log4j.ConsoleAppender
log4j.appender.console.Target = System.out
log4j.appender.console.Threshold=DEBUG
log4j.appender.console.layout = org.apache.log4j.PatternLayout
log4j.appender.console.layout.ConversionPattern=[%c]-%m%n

#文件输出的相关设置
log4j.appender.file = org.apache.log4j.RollingFileAppender
log4j.appender.file.File=./log/log.log
log4j.appender.fileAppender.Append = false  #文件追加
log4j.appender.file.MaxFileSize=10mb
log4j.appender.file.Threshold=DEBUG
log4j.appender.file.layout=org.apache.log4j.PatternLayout
log4j.appender.file.layout.ConversionPattern=[%p][%d{yy-MM-dd}][%c]%m%n

#日志输出级别
log4j.logger.org.mybatis=DEBUG
log4j.logger.org.apache=DEBUG
log4j.logger.java.sql=DEBUG
log4j.logger.java.sql.Connection=DEBUG
log4j.logger.java.sql.Statement=DEBUG
log4j.logger.java.sql.ResultSet=DEBUG
log4j.logger.java.sql.PreparedStatement=DEBUG
```
### 配置Mybatis-config
mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC
        "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd"
        >

<!--核心配置文件-->
<configuration>

    <!--设置-->
    <settings>
        <!--log4j日志工厂-->
        <setting name="logImpl" value="LOG4J"/>
        <!--开启全局缓存 默认开启-->
        <setting name="cacheEnabled" value="true"/>
    </settings>

    <!--起别名-->
    <typeAliases>
        <package name="pojo"/>
    </typeAliases>

    <!--映射器 mappers-->
    <mappers>
        <package name="mapper"/>
    </mappers>

</configuration>
```
### 配置XML配置文件
Spring-Mybatis.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:tx="http://www.springframework.org/schema/tx"
       xsi:schemaLocation="
       http://www.springframework.org/schema/beans
       https://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
       http://www.springframework.org/schema/tx
       http://www.springframework.org/schema/tx/spring-tx.xsd"
>

    <!-- 引入数据库配置文件  配置数据库dataSource -->
    <context:property-placeholder location="classpath:mysql.properties"/>

    <beans>

        <!--使用Spring提供的JDBC:DriverManagerDataSource-->
        <bean id="dateSourceSpring" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
            <property name="driverClassName"
                      value="${mysql.driverClassName}"/>
            <property name="url"
                      value="${mysql.url}"/>
            <property name="username"
                      value="${mysql.username}"/>
            <property name="password"
                      value="${mysql.password}"/>
        </bean>

        <!--使用druid提供的DruidDataSource-->
        <bean id="dateSourceDruid" class="com.alibaba.druid.pool.DruidDataSource">
            <property name="driverClassName"
                      value="${mysql.driverClassName}"/>
            <property name="url"
                      value="${mysql.url}"/>
            <property name="username"
                      value="${mysql.username}"/>
            <property name="password"
                      value="${mysql.password}"/>
        </bean>

        <!--利用Spring中SqlSessionFactoryBean生成sqlSessionFactory-->
        <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
            <!--配置数据源-->
            <property name="dataSource" ref="dateSourceDruid"/>
            <!--引入外部(绑定)mybatis-config.xml-->
            <property name="configLocation" value="mybatis-config.xml"/>
        </bean>

        <!--Mybatis下  配置扫描mapper接口包,动态实现mapper接口注入到spring容器中-->
        <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
            <!-- 注入sqlSessionFactory -->
            <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
            <!-- 给出需要扫描Dao接口包 -->
            <property name="basePackage" value="mapper"/>
        </bean>

        <!--开启 Spring 的事务处理功能    创建事务管理器   Mybatis,JDBC使用DataSourceTransactionManager  -->
        <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
            <!--注入数据源-->
            <property name="dataSource" ref="dateSourceSpring"/>
        </bean>

        <!--开启事务注解-->
        <tx:annotation-driven transaction-manager="transactionManager"/>

    </beans>

</beans>
```
applicationContext.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
        https://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
        https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/aop
        https://www.springframework.org/schema/aop/spring-aop.xsd">

    <!--引入Mybatis配置文件-->
    <import resource="classpath:Spring-Mybatis.xml"/>

    <!--开启注解支持-->
    <context:annotation-config/>
    <!--扫描注解-->
    <context:component-scan base-package="pojo mapper service"/>

    <!--开启AspectJ AOP注解支持-->
    <aop:aspectj-autoproxy/>

</beans>
```
### 配置实体类
```java
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.io.Serializable;

//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode

//spring
@Component(value = "user")
@Scope("singleton")    //Bean作用域

//Mybatis
@Alias("user")         //Mybatis类别名

public class User implements Serializable {
    private int id;
    private String name;
    private String pwd;
}
```
### 配置Mapper
#### UserMapper
```java
package mapper;

import org.apache.ibatis.annotations.Param;
import pojo.User;
import java.util.List;

public interface UserMapper {

    /**
     * 查找所有用户
     */
    List getUserList();

    /**
     * 得到用户的数量
     */
    int getUserCount();

    /**
     * 添加用户
     */
    int addUser( User user);

    /**
     * 通过ID删除用户
     */
    int deleteUserByID(@Param("id") int id);

    /**
     * 修改用户
     */
    int modifyUserById(User user);

}
```
#### userMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="mapper.UserMapper">

    <!--启动缓存-->
    <cache type="org.mybatis.caches.ehcache.EhcacheCache"/>

    <!--查找所有用户-->
    <select id="getUserList" resultType="user">
        select *
        from mybatis.user;
    </select>

    <!--查找用户的数量-->
    <select id="getUserCount" resultType="java.lang.Integer">
        select count(1)
        from mybatis.user;
    </select>

    <!--添加用户-->
    <insert id="addUser">
        insert into mybatis.user value (#{id}, #{name}, #{pwd});
    </insert>

    <!--删除用户-->
    <delete id="deleteUserByID">
        delete
        from mybatis.user
        where id = #{id};
    </delete>

    <!--修改用户-->
    <update id="modifyUserById">
        update mybatis.user
        set name=#{name},
            pwd=${pwd}
        where id = #{id};
    </update>

</mapper>
```
### 配置Service
#### UserService
```java
package service;

import org.apache.ibatis.annotations.Param;
import pojo.User;
import java.util.List;

public interface UserService {

    /**
     * 查找所有用户
     */
    List getUserList();

    /**
     * 得到用户的数量
     */
    int getUserCount();

    /**
     * 添加用户
     */
    int addUser( User user);

    /**
     * 通过ID删除用户
     */
    int deleteUserByID(@Param("id") int id);

    /**
     * 修改用户
     */
    int modifyUserById(User user);
}

```
#### UserServiceImpl
```java
package service;

import mapper.UserMapper;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import javax.annotation.Resource;
import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 16:54
 */

@Transactional
        (
                propagation = Propagation.REQUIRED,
                isolation = Isolation.REPEATABLE_READ,
                timeout = 10,
                readOnly = false
        )       // 配置事务

@Scope("singleton")
@Component(value = "userServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource(name = "userMapper")
    private UserMapper userMapper;

    @Override
    public List getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int getUserCount() {
        return userMapper.getUserCount();
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int deleteUserByID(int id) {
        return userMapper.deleteUserByID(id);
    }

    @Override
    public int modifyUserById(User user) {
        return userMapper.modifyUserById(user);
    }
}

```
### 测试代码
```java
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
```
## 事务
### 简介

- 事务使数据库操作的基本单元，逻辑上一组操作，要么都成功，要么都失败 加在Service层
- 经典场景，银行转账

四大特性

- 原子性   
- 一致性   
- 隔离性   
- 持久性   
### @Transactional      
可以加在类上 或者 方法上
```java
Propagation propagation() default Propagation.REQUIRED;  // 事务传播行为(7种) (事务如何执行)
Isolation isolation() default Isolation.DEFAULT;         // 事务隔离级别 MYSQL默认:REPEATABLE_READ(不可重复读) 
int timeout() default -1;                                // 超时时间 默认-1(不超时) 单位S 在一定事件内提交，否则回滚
boolean readOnly() default false;                        // 是否只读 默认:false true只能执行查询操作 
Class<? extends Throwable>[] rollbackFor() default {};   // 配置异常类型 (设置出现那些异常回滚) 
Class<? extends Throwable>[] noRollbackFor() default {}; // 配置异常类型 (设置出现那些异常不回滚)
```
#### 传播属性
```java
REQUIRED(0),
SUPPORTS(1),
MANDATORY(2),
REQUIRES_NEW(3),
NOT_SUPPORTED(4),
NEVER(5),
NESTED(6);
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1643008488316-c67c533d-9fba-46eb-aa86-316ee5ec12b2.png#clientId=ud00541eb-96f0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=484&id=u1vKW&margin=%5Bobject%20Object%5D&name=image.png&originHeight=484&originWidth=716&originalType=binary&ratio=1&rotation=0&showTitle=false&size=305447&status=done&style=none&taskId=uc11c2030-7ddf-440b-925d-bc529fa4824&title=&width=716)
#### 隔离级别
```java
DEFAULT(-1),
READ_UNCOMMITTED(1),
READ_COMMITTED(2),
REPEATABLE_READ(4),
SERIALIZABLE(8);
```
![image.png](https://cdn.nlark.com/yuque/0/2022/png/23219042/1643009099009-36ef5c7b-5948-493d-80bc-11f2018adce1.png#clientId=ud00541eb-96f0-4&crop=0&crop=0&crop=1&crop=1&from=paste&height=274&id=prq7Y&margin=%5Bobject%20Object%5D&name=image.png&originHeight=274&originWidth=564&originalType=binary&ratio=1&rotation=0&showTitle=false&size=121924&status=done&style=none&taskId=u8524ce78-0a51-4330-83aa-a9e15101f26&title=&width=564)

### 编写UserService接口
```java
public interface UserService { 
     void add_del();
}
```
### 实现UserService接口
```java
@Transactional
        (
                propagation = Propagation.REQUIRED,
                isolation = Isolation.REPEATABLE_READ,
                timeout = 10,
                readOnly = false
        )       // 配置事务

@Service(value = "userServiceImpl")
@Scope("singleton")
public class UserServiceImpl implements UserService {
    
    /**
     * UserDao实现类对象
     */
    private final UserDao userDao;

    public UserServiceImpl(@Qualifier(value = "userDaoImpl") UserDao userDao) {
        this.userDao = userDao;
    }
    
    /**
     * 事务的测试  异常
     */
    @Override
    public void add_del() {
        User user = ApplicationContextUtils.getApplicationContext().getBean("user", User.class);
        user.setId(1000);
        user.setName("zhazha");
        user.setPwd("888888");
        userDao.addUser(user);
        int num = 10 / 0;
        userDao.deleteUserByID(1000);
        userDao.queryUserList().forEach(System.out::println);
    }

}

```
### 开启事务注解
引入tx命名空间
```xml
xmlns:tx="http://www.springframework.org/schema/tx"
http://www.springframework.org/schema/tx
http://www.springframework.org/schema/tx/spring-tx.xsd
```
```xml
<beans>
      <!--开启 Spring 的事务处理功能    创建事务管理器   Mybatis,JDBC使用DataSourceTransactionManager  -->
      <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
          <!--注入数据源-->
          <property name="dataSource" ref="dateSourceSpring"/>
      </bean>

      <!--开启事务注解-->
      <tx:annotation-driven transaction-manager="transactionManager"/>
</beans>
```
```java
@ImportResource("applicationContext.xml")   // SSM通常采用XML加注解开发

@ComponentScan(basePackages = {"dao", "pojo", "service"})   // 扫描包
@EnableTransactionManagement    // 开启事务
@Scope("singleton")
@Configuration
public class config {
    
}


```
### 测试
```java
@Test
public void add_del(){
  ApplicationContext applicationContext = ApplicationContextUtils.getApplicationContext();
  UserService userService = applicationContext.getBean("userServiceImpl", UserService.class);
  userService.add_del();
}
```


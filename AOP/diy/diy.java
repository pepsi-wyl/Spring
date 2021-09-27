package diy;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author by wyl
 * @date 2021/9/26.
 */

@Component             //托管到Spring中
@Scope("singleton")    //Bean作用域

@Aspect                //标注此类是切面类

public class diy {

    /**
     * 前置
     */
    @Before("execution(* dao.UserDaoImpl.*(..))")
    public void before() {
        System.out.println("before!");
    }

    @After("execution(* dao.UserDaoImpl.*(..))")
    public void after() {
        System.out.println("after!");
    }

    @Around("execution(* dao.UserDaoImpl.*(..))")
    public void around(ProceedingJoinPoint point) throws Throwable {
        System.out.println("执行前");
//        System.out.println("signature" + point.getSignature());//获得签名
        point.proceed();    //相当于过滤
        System.out.println("执行后");
    }

}

package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

/**
 * @author by wyl
 * @date 2021/11/2.19点39分
 */

@ComponentScan(basePackages = {"mapper", "diy"})   //扫描注解包
@EnableAspectJAutoProxy(proxyTargetClass = true)   //开启AspectJ AOP注解支持

@Scope("singleton")                                //配置生命周期
@Configuration                                     //表面此类是配置类
public class ConfigAOP {

}

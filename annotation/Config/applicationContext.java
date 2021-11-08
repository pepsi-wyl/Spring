package Config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Scope;

/**
 * @author by wyl
 * @date 2021/9/25.14点38分
 */

/**
 * 表示这是一个Spring配置类(类似于applicationContext.xml)
 * 本身也会被Spring托管
 */

@Import(config.class)      //引入其他配置文件

@Configuration             //作为配置类 替代XML配置文件
@Scope("singleton")

@ComponentScan(basePackages = {"pojo", "dao", "service", "controller"})      //扫描注解包

public class applicationContext {



}

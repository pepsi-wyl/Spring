package config;

import org.springframework.context.annotation.*;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 15:49
 */

@ImportResource("applicationContext.xml")
@ComponentScan(basePackages = {"dao", "pojo", "service"})   // 扫描包
@EnableTransactionManagement    // 开启事务
@Scope("singleton")
@Configuration
public class config {

}

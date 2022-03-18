package service;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import mapper.UserMapper;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import pojo.User;
import utils.ApplicationContextUtils;

import javax.annotation.Resource;

/**
 * @author by wyl
 * @date 2021/10/3.10点01分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAspectJAutoProxy

@Service(value = "userService")
@Scope("singleton")


/**
 * 注解配置事务 @Transactional      可以加在类上/方法上
 * propagation:    事务传播行为(7种)      REQUIRED  REQUIRES_NEW    (事务如何执行)
 * isolation:      事务隔离级别           MYSQL默认:REPEATABLE_READ(不可重复读)
 * timeout:        超时时间              默认-1(不超时)  可以设置 S为单位    (在一定事件内提交，否则回滚)
 * readOnly:       是否只读              默认:false  true只能执行查询操作
 * rollbackFor:    回滚                  配置异常类型      (设置出现那些异常回滚)
 * noRollbackFor:  不回滚                配置异常类型      (设置出现那些异常回滚)
 */

@Transactional
        (
                propagation = Propagation.REQUIRED,
                isolation = Isolation.REPEATABLE_READ,
                timeout = 10,
                readOnly = false
        )

public class UserService {


    /**
     * 注入userMapper
     */
    @Resource(name = "userMapper")
    private UserMapper userMapper;


    /**
     * 事务的测试
     * 删除异常
     */
    public void add_del() {
        User user = ApplicationContextUtils.getApplicationContext().getBean("user", User.class);
        user.setId(5);
        user.setName("zhazha");
        user.setPwd("888888");
        /**
         * 模拟异常
         */
        //int num = 10 / 0;
        userMapper.addUser(user);
        userMapper.deleteUserByID(5);
        userMapper.getUserList().forEach((v) -> System.out.println(v));
    }


}

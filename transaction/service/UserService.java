package service;

import dao.UserMapper;
import org.springframework.transaction.annotation.Isolation;
import pojo.User;
import utils.ApplicationContextUtils;

import lombok.*;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author by wyl
 * @date 2021/10/3.10点01分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EnableAspectJAutoProxy

@Service
@Scope("singleton")


/**
 * 注解配置事务 @Transactional
 * propagation:    事务传播行为     REQUIRED  REQUIRES_NEW
 * isolation:      事务隔离级别     MYSQL默认:REPEATABLE_READ(不可重复读)
 * timeout:        超时时间        默认-1(不超时)  可以设置 S为单位
 * readOnly:       是否只读        默认:false  true只能执行查询操作
 * rollbackFor:    回滚           配置异常类型
 * noRollbackFor:  不回滚          配置异常类型
 */

@Transactional
        (
                propagation = Propagation.REQUIRED,
                isolation = Isolation.REPEATABLE_READ,
                timeout = 10
        )

public class UserService {


    /**
     * 注入userMapper
     */
    @Resource(name = "userMapperImpl")
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
        userMapper.addUser(user);
        userMapper.deleteUser(5);
        userMapper.getUserList().forEach((v) -> System.out.println(v));
    }


}

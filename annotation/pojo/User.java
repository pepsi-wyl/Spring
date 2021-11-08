package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;


/**
 * @author by wyl
 * @date 2021/9/25.11点24分
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

/**
 * @Component  ------>  @Repository(dao)  @Service(Service)   @Controller(controller)
 * 相当于<bean id="user" class="pojo.User"/>  注册bean
 */
//@Component           //默认为类名小写
@Component(value = "user")

//作用域
@Scope("singleton")  //singleton 单例模式   prototype 原型模式

public class User {

    private String name;

    //相当于        <property name="name" value="zhazha"/>
    @Value("zhazha")
    public void setName(@Nullable String name) {
        this.name = name;
    }


}

package pojo;

import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author by wyl
 * @date 2021/9/26.15点00分
 */

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

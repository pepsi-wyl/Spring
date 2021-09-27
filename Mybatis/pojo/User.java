package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * @author by wyl
 * @date 2021/9/26.15点00分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Component
@Scope("singleton")    //Bean作用域

@Alias("user")
public class User implements Serializable {

    private int id;
    private String name;
    private String pwd;

}

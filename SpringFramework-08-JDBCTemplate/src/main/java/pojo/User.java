package pojo;

import lombok.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author by wyl
 * @date 2021/9/26.19点56分
 */

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

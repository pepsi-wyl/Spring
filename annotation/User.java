
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


/**
 * @author by wyl
 * @date 2021/9/25.11点24分
 */


@Data
@NoArgsConstructor
@AllArgsConstructor


@Component
//相当于<bean id="user" class="pojo.User"/>
@Scope("singleton")
//作用域
public class User {

    @Value("zhazha")
    //相当于        <property name="name" value="zhazha"/>
    private String name;

}

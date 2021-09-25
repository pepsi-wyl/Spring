package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.lang.Nullable;

import javax.annotation.Resource;

/**
 * @author by wyl
 * @date 2021/9/25.09点54分
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class People {

    /**
     * 两者都可以写在字段和setter方法上。两者如果都写在字段上，那么就不需要再写setter方法。
     */

    /**
     * Spring注解  按照类型(byType)装配依赖对象
     *
     * @Autowired
     * @Autowired(required = false)   允许null值
     * @Autowired(required = true)    不允许null值
     * @Qualifier(value = "cat")      按照名称(byName)来装配，可以结合@Qualifier注解一起使用
     */

    @Autowired(required = false)
    @Qualifier(value = "cat")
    private Cat cat;

    /**
     * J2EE原生注解   按照类型(byName)装配依赖对象
     *
     * @Resource
     * @Resource(name = "dog")    @Resource(name="dog") =@Autowired+@Qualifier(value = "dog")
     */
    @Resource(name = "dog")
    private Dog dog;

    private String name;

    //这个字段可以为null
    public void setName(@Nullable String name) {
        this.name = name;
    }


}

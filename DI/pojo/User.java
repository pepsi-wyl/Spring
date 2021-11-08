package pojo;

import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * @author by wyl
 * @date 2021/9/24.20点28分
 */


@ToString
@EqualsAndHashCode

public class User {

    private String name;

    public User() {
        System.out.println("User无参构造!");
    }

    public User(String name) {
        this.name = name;
        System.out.println("User有参构造!");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author by wyl
 * @date 2021/9/24.21点01分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

public class Person {
    private String name;
    private int age;
}

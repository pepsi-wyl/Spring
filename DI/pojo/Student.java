package pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author by wyl
 * @date 2021/9/24.19点51分
 */


/**
 * lombok生成 java Bean
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode

public class Student {
    private String name;                //name ---  value
    private Address address;            //name ---  ref
    private String[] books;             //name ---> array ---> value
    private List<String> hobbies;       //name ---> list  ---> value
    private Map<String, String> card;   //name ---> map   ---> entry --- value
    private Set<String> games;          //name ---> set   ---> value
    private String wife;                //name ---> null
    private Properties info;            //name ---> props ---> prop
}

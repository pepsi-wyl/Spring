package service;

import dao.UserDao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author by wyl
 * @date 2021/9/24.10点45分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode


public class UserService {

    /**
     * Spring 必须提供属性的set方法  依赖注入
     */
    private UserDao userDao;

    /**
     * 方法
     */
    public void printf() {
        System.out.println(userDao.getDate());
    }

}

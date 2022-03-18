package dao;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pojo.User;
import java.util.List;

/**
 * @author by pepsi-wyl
 * @date 2022-01-24 11:16
 */

@Repository("userDaoImpl")
@Scope("singleton")
public class UserDaoImpl implements UserDao {

    /**
     * 注入jdbcTemplate 对象
     */
    private final JdbcTemplate jdbcTemplate;

    public UserDaoImpl(@Qualifier(value = "jdbcTemplate") JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * 添加user对象
     */
    @Override
    public int addUser(User user) {
        return jdbcTemplate.update
                ("insert into mybatis.user value (?,?, ?)", user.getId(), user.getName(), user.getPwd());
    }

    /**
     * 删除user对象 ById
     */
    @Override
    public int deleteUserByID(int id) {
        return jdbcTemplate.update
                ("delete from mybatis.user where id=?", id);
    }

    /**
     * 修改user对象 ById
     */
    @Override
    public int updateUser(User user) {
        return jdbcTemplate.update
                ("update mybatis.user set name=?,pwd=? where id=?", user.getName(), user.getPwd(), user.getId());
    }

    /**
     * 查询UserCount
     */
    @Override
    public int queryCount() {
        return jdbcTemplate.queryForObject
                ("select count(*) from mybatis.user", Integer.class);
    }

    /**
     * 查询UserByID
     * RowMapper 返回不同数据类型 使这个接口里面实现类完成数据封装
     */
    @Override
    public User queryUserByID(int id) {
        return jdbcTemplate.queryForObject
                ("select * from mybatis.user where id=?", new BeanPropertyRowMapper<User>(User.class), id);
    }

    /**
     * 查询所有用户 List集合
     */
    @Override
    public List<User> queryUserList() {
        return jdbcTemplate.query
                ("select * from mybatis.user", new BeanPropertyRowMapper<User>(User.class));
    }

    /**
     * 批量添加
     */
    @Override
    public int[] addUserBatch(List<Object[]> batchArgs) {
        return jdbcTemplate.batchUpdate
                ("insert into mybatis.user value (?,?, ?)", batchArgs);
    }

    /**
     * 批量修改
     */
    @Override
    public int[] updateUserBatch(List<Object[]> batchArgs) {
        return jdbcTemplate.batchUpdate
                ("update mybatis.user set name=?,pwd=? where id=?", batchArgs);
    }

    /**
     * 批量删除
     */
    @Override
    public int[] deleteUserBatch(List<Object[]> batchArgs) {
        return jdbcTemplate.batchUpdate
                ("delete from mybatis.user where id=?", batchArgs);
    }

}

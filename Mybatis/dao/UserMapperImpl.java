package dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author by wyl
 * @date 2021/9/26.16点14分
 */

@Data
@AllArgsConstructor
@NoArgsConstructor

@Repository
@Scope("singleton")      //Bean作用域

public class UserMapperImpl implements UserMapper {

    @Resource(name = "sqlSession")
    private SqlSessionTemplate sqlSessionTemplate;

    @Override
    public List getUserList() {
        return sqlSessionTemplate.getMapper(UserMapper.class).getUserList();
    }

}

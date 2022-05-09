package com.saihou.mapper;

import com.saihou.entity.Role;
import com.saihou.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/15 17:34
 */
public class UserMapperTest {

    private InputStream in;
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before // 用于在测试方法之前调用
    public void init() {
        try {
            in = Resources.getResourceAsStream("mybatisConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            sqlSession = factory.openSession();
            userMapper = sqlSession.getMapper(UserMapper.class);
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    @After // 用于在测试方法之后调用
    public void destroy() {
        try {
            // 提交事务
            sqlSession.commit();
            sqlSession.close();
            in.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    /**
     * 测试查询所有
     */
    @Test
    public void testFindAll() {
        List<User> userList = userMapper.findAll();

        for (User user : userList) {
            System.out.println(user);

            for (Role role : user.getRoles()) {
                System.out.println(role);
            }
        }
    }
}

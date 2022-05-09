package com.saihou.mapper;

import com.saihou.entity.QueryVo;
import com.saihou.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/14 20:47
 */
public class MybatisTest {

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
            // sqlSession = factory.openSession(true);
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
        }
    }

    /**
     * 测试根据id查找
     */
    @Test
    public void testFindById() {
        User user = userMapper.findById(2);
        System.out.println(user);
    }

    /**
     * 测试根据名称模糊查询
     */
    @Test
    public void testFindByName() {
        List<User> users = userMapper.findByName("%j%");
        // List<User> users = userMapper.findByName("j");

        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 测试使用QueryVo作为查询条件
     */
    @Test
    public void testFindByQueryVo() {
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("%j%");
        vo.setUser(user);

        List<User> users = userMapper.findByQueryVo(vo);
        // List<User> users = userMapper.findByName("j");

        for (User u : users) {
            System.out.println(u);
        }
    }

    /**
     * 测试条件查询
     */
    @Test
    public void testFindByCondition() {
        User user = new User();
        user.setUsername("tom");
        user.setGender("male");

        List<User> users = userMapper.findByCondition(user);

        for (User u : users) {
            System.out.println(u);
        }
    }

    @Test
    public void testFindByIds() {
        QueryVo vo = new QueryVo();
        List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(5);
        vo.setIds(ids);

        List<User> users = userMapper.findByIds(vo);

        for (User user : users) {
            System.out.println(user);
        }
    }
}

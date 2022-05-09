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
     * 测试保存操作
     */
    @Test
    public void testSave() {
        User user = new User();
        user.setUsername("mybatis saveUser last_id");
        user.setBirthday(new Date());
        user.setGender("female");
        user.setAddress("kyouto");

        System.out.println("before: " + user);
        userMapper.saveUser(user);
        System.out.println("after: " + user);
    }

    /**
     * 测试更新操作
     */
    @Test
    public void testUpdate() {
        User user = new User();
        user.setId(6);
        user.setUsername("mybatis updateUser");
        user.setBirthday(new Date());
        user.setGender("male");
        user.setAddress("kyouto");

        userMapper.updateUser(user);
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        userMapper.deleteUser(4);
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
     * 测试查询总记录条数
     */
    @Test
    public void testFindTotal() {
        int total = userMapper.findTotal();
        System.out.println(total);
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
}

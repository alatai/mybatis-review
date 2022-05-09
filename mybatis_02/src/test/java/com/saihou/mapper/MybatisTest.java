package com.saihou.mapper;

import com.saihou.entity.User;
import com.saihou.mybatis.io.Resources;
import com.saihou.mybatis.sqlsession.SqlSession;
import com.saihou.mybatis.sqlsession.SqlSessionFactory;
import com.saihou.mybatis.sqlsession.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/14 20:47
 */
public class MybatisTest {

    public static void main(String[] args) {
        // ① 读取配置文件/⑥ 释放资源
        try (InputStream in = Resources.getResourceAsStream("mybatisConfig.xml")) {
            // ② 创建SqlSessionFactory工厂
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            SqlSessionFactory factory = builder.build(in);
            // ③ 使用工厂生产SqlSession对象
            SqlSession sqlSession = factory.openSession();
            // ④ 使用SqlSession创建mapper接口的代理对象
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            // ⑤ 使用代理对象执行方法
            List<User> userList = userMapper.findAll();

            for (User user : userList) {
                System.out.println(user);
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}

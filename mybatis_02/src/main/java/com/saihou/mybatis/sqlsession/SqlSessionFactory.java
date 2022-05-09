package com.saihou.mybatis.sqlsession;

/**
 * 自定义Mybatis中和数据库交互的核心类
 * 它可以创建mapper接口的代理对象
 *
 * @author Alatai
 * @version 1.0
 * @date 2021/04/14 22:19
 */
public interface SqlSessionFactory {

    /**
     * 用于打开一个新的SqlSession对象
     */
    SqlSession openSession();
}

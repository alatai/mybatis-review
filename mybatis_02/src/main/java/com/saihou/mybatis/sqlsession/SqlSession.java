package com.saihou.mybatis.sqlsession;

import com.saihou.mapper.UserMapper;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/14 22:22
 */
public interface SqlSession {

    /**
     * 根据参数创建一个参数代理对象
     * @param mapperInterfaceClass mapper的接口字节码
     */
    <T> T getMapper(Class<T> mapperInterfaceClass);
}

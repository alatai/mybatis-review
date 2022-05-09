package com.saihou.mapper;

import com.saihou.entity.User;

import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/14 20:19
 */
public interface UserMapper {

    /**
     * 查询所有
     *
     * @return
     */
    // 注解情况
    // @Select("SELECT * FROM")
    List<User> findAll();
}

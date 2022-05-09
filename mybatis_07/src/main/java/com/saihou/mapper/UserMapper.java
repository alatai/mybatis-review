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
     * 查询所有，同时获取到用户下所有账户的信息
     */
    List<User> findAll();

    /**
     * 根据id查询用户信息
     */
    User findById(Integer id);
}

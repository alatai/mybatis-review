package com.saihou.mapper;

import com.saihou.entity.QueryVo;
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
     */
    // 注解情况
    // @Select("SELECT * FROM")
    List<User> findAll();

    /**
     * 保存方法
     */
    void saveUser(User user);

    /**
     * 更新方法
     */
    void updateUser(User user);

    /**
     * 删除方法
     */
    void deleteUser(Integer id);

    /**
     * 根据id查询用户信息
     */
    User findById(Integer id);

    /**
     * 根据名称模糊查询
     */
    List<User> findByName(String name);

    /**
     * 查询总用户数
     */
    int findTotal();

    /**
     * 根据QueryVo中的条件查询用户
     */
    List<User> findByQueryVo(QueryVo vo);
}

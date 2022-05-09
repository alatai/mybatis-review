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
     * 根据id查询用户信息
     */
    User findById(Integer id);

    /**
     * 根据名称模糊查询
     */
    List<User> findByName(String name);

    /**
     * 根据QueryVo中的条件查询用户
     */
    List<User> findByQueryVo(QueryVo vo);

    /**
     * 根据传入的参数条件查询
     * @param user 查询条件，有可能有用户名，有可能有性别，也有可能有地址...
     */
    List<User> findByCondition(User user);

    /**
     * 根据QueryVo中提供的id集合查询
     */
    List<User> findByIds(QueryVo vo);
}

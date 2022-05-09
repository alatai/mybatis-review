package com.saihou.mapper;

import com.saihou.entity.Role;

import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/15 18:23
 */
public interface RoleMapper {

    /**
     * 查询所有角色
     */
    List<Role> findAll();
}

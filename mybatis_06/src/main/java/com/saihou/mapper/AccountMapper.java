package com.saihou.mapper;

import com.saihou.entity.Account;

import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/15 17:09
 */
public interface AccountMapper {

    /**
     * 查询所有账户，同时还要获取到当前账户的所属用户信息
     */
    List<Account> findAll();

    /**
     * 根据用户id查询账户
     */
    List<Account> findByUid(Integer uid);
}

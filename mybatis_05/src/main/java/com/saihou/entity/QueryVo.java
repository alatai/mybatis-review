package com.saihou.entity;

import java.util.List;

/**
 * 查询条件对象
 *
 * @author Alatai
 * @version 1.0
 * @date 2021/04/15 0:47
 */
public class QueryVo {

    private User user;
    private List<Integer> ids;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
    }
}

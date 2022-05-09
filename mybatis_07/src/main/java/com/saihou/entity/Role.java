package com.saihou.entity;

import java.io.Serializable;
import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/15 18:21
 */
public class Role implements Serializable {

    private Integer id;
    private String roleName;
    private String roleDesc;

    // 多对多的关系映射，一个角色可以赋予多个用户
    private List<User> users;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                '}';
    }
}

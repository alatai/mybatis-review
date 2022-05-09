package com.saihou.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author Alatai
 * @version 1.0
 * @date 2021/04/14 20:15
 */
public class User implements Serializable {

    private Integer id;
    private String username;
    private Date birthday;
    private String gender;
    private String address;

    // 一对多关系映射，主表实体应该包含从表实体的集合引用
    private List<Account> accounts;

    public Integer getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthday() {
        return birthday;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}

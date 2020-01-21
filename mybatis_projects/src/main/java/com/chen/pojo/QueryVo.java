package com.chen.pojo;

import java.io.Serializable;

public class QueryVo implements Serializable {
    private Users users;

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "QueryVo{" +
                "users=" + users +
                '}';
    }

    public QueryVo() {
    }
}

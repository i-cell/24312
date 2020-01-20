package com.chen.Dao;

import com.chen.pojo.QueryVo;
import com.chen.pojo.Users;

import java.util.List;

public interface IUsersDao {
    /**
     * 查询所有
     * @return
     */
    List<Users> findAll();

    /**
     * 根据id查询
     * @param usersid
     * @return
     */
    Users findById(Integer usersid);

    /**
     * 保存所有
     * @param users
     * @return
     */
    int saveUsers(Users users);

    /**
     * 根据名称模糊查询
     * @param username
     * @return
     */
    List<Users> findByName(String username);

    /**
     * 根据findByVo中的条件查询用户
     * @param queryVo
     * @return
     */
    List<Users> findByVo(QueryVo queryVo);
}

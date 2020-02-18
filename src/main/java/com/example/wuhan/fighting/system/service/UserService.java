package com.example.wuhan.fighting.system.service;

import com.example.wuhan.fighting.system.entity.User;

import java.util.List;

/**
 * @Author Liupeiqing
 * @Date 2020/2/18 22:13
 * @Version 1.0
 */
public interface UserService {

    User save(User user);

    List<User> findAll();

    User findUserById(String id);

    User findUserByUserNameAndPassword(String username,String password);

}

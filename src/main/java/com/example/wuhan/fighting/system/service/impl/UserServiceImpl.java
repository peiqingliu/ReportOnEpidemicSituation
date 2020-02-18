package com.example.wuhan.fighting.system.service.impl;

import com.example.wuhan.fighting.system.entity.User;
import com.example.wuhan.fighting.system.repository.UserRepository;
import com.example.wuhan.fighting.system.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Liupeiqing
 * @Date 2020/2/18 22:16
 * @Version 1.0
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(String id) {
        return userRepository.findById(id).isPresent() ? userRepository.findById(id).get() : null;
    }

    @Override
    public User findUserByUserNameAndPassword(String username,String password) {
        return userRepository.findUserByUsernameAndPassword(username,password);
    }
}

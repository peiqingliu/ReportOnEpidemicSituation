package com.example.wuhan.fighting.system.repository;

import com.example.wuhan.fighting.system.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @Author Liupeiqing
 * @Date 2020/2/18 22:14
 * @Version 1.0
 */
public interface UserRepository extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {

    User findUserByUsernameAndPassword(String username,String password);
}

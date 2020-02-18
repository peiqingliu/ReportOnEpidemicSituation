package com.example.wuhan.fighting.system.controller;

import com.example.wuhan.fighting.system.entity.User;
import com.example.wuhan.fighting.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author Liupeiqing
 * @Date 2020/2/18 22:18
 * @Version 1.0
 */

@RestController
@RequestMapping("/system")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/hello")
    public Mono<String> hello() {   // 【改】返回类型为Mono<String>
        return Mono.just("Welcome to reactive world ~");     // 【改】使用Mono.just生成响应式数据
    }

    @GetMapping("/findUserById")
    public Mono<User> findUserById(@RequestParam(value = "userId") String userId){
        User user = userService.findUserById(userId);
        return Mono.just(user);
    }

    @GetMapping("/findAll")
    public Flux<User> findAll(){
        List<User> users = userService.findAll();
        return Flux.fromIterable(users);
    }

    @PostMapping("/save")
    public Mono<ResponseEntity<String>> save(@RequestBody User user){
        User u = userService.save(user);
        if (u != null){
            return Mono.just(new ResponseEntity<String>("添加成功", HttpStatus.CREATED));
        }
        return Mono.just(new ResponseEntity<String>("添加失败", HttpStatus.OK));
    }

    @PostMapping("/getUserByUserNameAndPassword")
    public Mono<User> getUserByUserNameAndPassword(@RequestBody User u){
        String username = u.getUsername();
        String password = u.getPassword();
        User user = userService.findUserByUserNameAndPassword(username,password);
        return Mono.just(user);
    }
}

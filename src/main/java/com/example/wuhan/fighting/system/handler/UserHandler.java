package com.example.wuhan.fighting.system.handler;

import com.example.wuhan.fighting.system.entity.User;
import com.example.wuhan.fighting.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author Liupeiqing
 * @Date 2020/2/18 22:14
 * @Version 1.0
 */
@Component
public class UserHandler {

    @Autowired
    private UserService userService;

    public Mono<ServerResponse> getUserByUserId(ServerRequest request){
        String userId = request.queryParam("userId").get();
        User user= userService.findUserById(userId);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(user),User.class);
    }

    public Mono<ServerResponse> getAllUser(ServerRequest serverRequest){
        List<User> allUser = userService.findAll();
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Flux.fromIterable(allUser),User.class);
    }

    public Mono<ServerResponse> getUserByUserNameAndPassword(ServerRequest request){
        String username = request.queryParam("username").get();
        String password = request.queryParam("password").get();
        User user = userService.findUserByUserNameAndPassword(username,password);
        return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(Mono.just(user),User.class);
    }


}

package com.example.wuhan.fighting.system.router;

import com.example.wuhan.fighting.system.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

/**
 * @Author Liupeiqing
 * @Date 2020/2/18 22:15
 * @Version 1.0
 */
@Configuration
public class RoutingConfiguration {
    @Bean
    public RouterFunction<ServerResponse> monoRouterFunction(UserHandler userHandler){
        return route(GET("/system/findUserByIdRouter").and(accept(MediaType.APPLICATION_JSON)),userHandler :: getUserByUserId)
                .andRoute(GET("system/findAllRouter"),userHandler :: getAllUser)
                .andRoute(GET("system/getUserByUserNameAndPassword").and(accept(MediaType.APPLICATION_JSON)),userHandler :: getUserByUserNameAndPassword);
    }
}

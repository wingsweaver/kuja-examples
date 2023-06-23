package com.example.webflux.lib.common.routing;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeferedRouterFunctionConfig {
    @Value("${example.webflux.router-defered.path:/api/todo6}")
    private String apiPath;

    @Bean
    public RouterFunction<ServerResponse> deferedTodoRouterFunction(DeferedToDoHandler toDoHandler) {
        return route()
                .GET(apiPath, toDoHandler::findAll)
                .GET(apiPath + "/{id}", toDoHandler::findById)
                .DELETE(apiPath + "/{id}", toDoHandler::deleteById)
                .GET(apiPath + "/complete/{id}", toDoHandler::completeById)
                .GET(apiPath + "/open/{id}", toDoHandler::openById)
                .build();
    }
}

package com.example.webflux.lib.common;

import com.example.webflux.lib.common.filter.TraceIdWebFilter;
import com.example.webflux.lib.common.routing.DeferedRouterFunctionConfig;
import com.example.webflux.lib.common.routing.DeferedToDoHandler;
import com.example.webflux.lib.common.routing.RouterFunctionConfig;
import com.example.webflux.lib.common.routing.ToDoHandler;
import com.example.webmvc.lib.common.service.TodoService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({RouterFunctionConfig.class, DeferedRouterFunctionConfig.class})
public class ExampleWebMvcLibFluxConfiguration {
    @Bean
    public TraceIdWebFilter traceWebFilter() {
        return new TraceIdWebFilter();
    }

    @Bean
    public ToDoHandler toDoHandler(TodoService todoService) {
        return new ToDoHandler();
    }

    @Bean
    public DeferedToDoHandler deferedToDoHandler(TodoService todoService) {
        return new DeferedToDoHandler();
    }
}

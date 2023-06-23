package com.example.webmvc.lib.common;

import com.example.webmvc.lib.common.controller.TodoController;
import com.example.webmvc.lib.common.controller.TodoController2;
import com.example.webmvc.lib.common.controller.TodoController3;
import com.example.webmvc.lib.common.controller.TodoController4;
import com.example.webmvc.lib.common.customizer.TraceReturnValueCustomizer;
import com.example.webmvc.lib.common.errors.TodoErrorDefinition;
import com.example.webmvc.lib.common.service.TodoService;
import com.example.webmvc.lib.common.service.TodoServiceImpl;
import com.example.webmvc.lib.common.service.TodoServiceReactive;
import com.example.webmvc.lib.common.service.TodoServiceReactiveImpl;
import com.wingsweaver.kuja.common.web.EnableKujaCommonWeb;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableKujaCommonWeb
public class ExampleWebMvcLibCommonConfiguration {
    @Bean
    public TodoController todoController() {
        return new TodoController();
    }

    @Bean
    public TodoService todoService() {
        return new TodoServiceImpl();
    }

    @Bean
    public TraceReturnValueCustomizer traceReturnValueCustomizer() {
        return new TraceReturnValueCustomizer();
    }

    @Bean
    public TodoErrorDefinition todoErrorDefinition() {
        return new TodoErrorDefinition();
    }

    @Configuration
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.SERVLET)
    public static class ServletConfiguration {
        @Bean
        public TodoController2 todoController2() {
            return new TodoController2();
        }

        @Bean
        public TodoController3 todoController3() {
            return new TodoController3();
        }
    }

    @Configuration
    @ConditionalOnWebApplication(type = ConditionalOnWebApplication.Type.REACTIVE)
    public static class ReactiveConfiguration {
        @Bean
        public TodoServiceReactive todoServiceReactive(TodoService todoService) {
            return new TodoServiceReactiveImpl();
        }

        @Bean
        public TodoController4 todoController4() {
            return new TodoController4();
        }
    }

}

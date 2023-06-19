package com.example.webflux.lib.common.routing;

import com.example.webmvc.lib.common.service.TodoServiceReactive;
import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValueFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class DeferedToDoHandler implements InitializingBean {
    @Autowired
    private ReturnValueFactory returnValueFactory;

    @Autowired
    private TodoServiceReactive todoService;

    @Value("${example.webflux.defer:1000}")
    private long deferTime;

    private Scheduler scheduler;

    @Override
    public void afterPropertiesSet() throws Exception {
        if (this.todoService == null) {
            throw new IllegalStateException("[todoService] is null");
        }

        Executor executor = Executors.newScheduledThreadPool(10);
        this.scheduler = Schedulers.fromExecutor(executor);
    }

    public Mono<ServerResponse> findAll(ServerRequest serverRequest) {
        return this.todoService.getTodoList()
                .map(value -> this.returnValueFactory.success(value))
                .delayElement(Duration.ofMillis(this.deferTime), this.scheduler)
                .flatMap(value -> ServerResponse.ok().bodyValue(value));
    }

    private long resolveId(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        if (!StringUtils.hasText(id)) {
            throw new IllegalArgumentException("[id] parameter is not specified");
        }
        try {
            return Long.parseLong(id);
        } catch (Exception ex) {
            throw new IllegalArgumentException("[id] parameter is not a number", ex);
        }
    }

    public Mono<ServerResponse> findById(ServerRequest serverRequest) {
        return this.todoService.getTodoById(this.resolveId(serverRequest))
                .map(value -> this.returnValueFactory.success(value))
                .delayElement(Duration.ofMillis(this.deferTime), this.scheduler)
                .flatMap(value -> ServerResponse.ok().bodyValue(value));
    }

    public Mono<ServerResponse> deleteById(ServerRequest serverRequest) {
        return this.todoService.deleteTodoById(this.resolveId(serverRequest))
                .thenReturn(this.returnValueFactory.success())
                .delayElement(Duration.ofMillis(this.deferTime), this.scheduler)
                .flatMap(value -> ServerResponse.ok().bodyValue(value));
    }

    public Mono<ServerResponse> completeById(ServerRequest serverRequest) {
        return this.todoService.completeTodoById(this.resolveId(serverRequest))
                .thenReturn(this.returnValueFactory.success())
                .delayElement(Duration.ofMillis(this.deferTime), this.scheduler)
                .flatMap(value -> ServerResponse.ok().bodyValue(value));
    }

    public Mono<ServerResponse> openById(ServerRequest serverRequest) {
        return this.todoService.openTodoById(this.resolveId(serverRequest))
                .thenReturn(this.returnValueFactory.success())
                .delayElement(Duration.ofMillis(this.deferTime), this.scheduler)
                .flatMap(value -> ServerResponse.ok().bodyValue(value));
    }
}

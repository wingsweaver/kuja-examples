package com.example.webmvc.lib.common.service;

import com.example.webmvc.lib.common.dto.TodoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class TodoServiceReactiveImpl implements TodoServiceReactive {
    @Autowired
    private TodoService todoService;

    @Override
    public Mono<List<TodoDto>> getTodoList() {
        return Mono.fromCallable(() -> this.todoService.getTodoList());
    }

    @Override
    public Mono<TodoDto> getTodoById(Long id) {
        return Mono.fromCallable(() -> this.todoService.getTodoById(id));
    }

    @Override
    public Mono<Void> deleteTodoById(Long id) {
        return Mono.fromRunnable(() -> this.todoService.deleteTodoById(id));
    }

    @Override
    public Mono<Void> completeTodoById(Long id) {
        return Mono.fromRunnable(() -> this.todoService.completeTodoById(id));
    }

    @Override
    public Mono<Void> openTodoById(Long id) {
        return Mono.fromRunnable(() -> this.todoService.openTodoById(id));
    }
}

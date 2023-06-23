package com.example.webmvc.lib.common.service;

import com.example.webmvc.lib.common.dto.TodoDto;
import reactor.core.publisher.Mono;

import java.util.List;

public interface TodoServiceReactive {
    Mono<List<TodoDto>> getTodoList();

    Mono<TodoDto> getTodoById(Long id);

    Mono<Void> deleteTodoById(Long id);

    Mono<Void> completeTodoById(Long id);

    Mono<Void> openTodoById(Long id);
}

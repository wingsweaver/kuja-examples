package com.example.webmvc.lib.common.service;

import com.example.webmvc.lib.common.dto.TodoDto;

import java.util.List;

public interface TodoService {
    List<TodoDto> getTodoList();

    TodoDto getTodoById(Long id);

    void deleteTodoById(Long id);

    void completeTodoById(Long id);

    void openTodoById(Long id);
}

package com.example.webmvc.lib.common.service;

import com.example.webmvc.lib.common.dto.TodoDto;
import com.example.webmvc.lib.common.errors.TodoErrorDefinition;
import com.wingsweaver.kuja.common.boot.model.AbstractService;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogSection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoServiceImpl extends AbstractService implements TodoService, InitializingBean {
    private static final Logger LOGGER = LoggerFactory.getLogger(TodoServiceImpl.class);

    private final List<TodoDto> todoList = new LinkedList<>();

    private final AtomicLong counter = new AtomicLong(0);

    @Override
    public List<TodoDto> getTodoList() {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            return new ArrayList<>(this.todoList);
        } finally {
            logSection.leave();
        }
    }

    @Override
    public TodoDto getTodoById(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            TodoDto todoDto = this.findById(id);
            if (todoDto == null) {
                logSection.log(Level.ERROR, "trigger exception");
                throwBusinessException("E0001", id);
//                throw new ExtendedRuntimeException("Todo not found: " + id)
//                        .withExtendedAttribute("id", id);
            }
            return todoDto;
        } finally {
            logSection.leave();
        }
    }

    private TodoDto findById(Long id) {
        return this.todoList.parallelStream()
                .filter(todoDto -> todoDto.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void deleteTodoById(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            TodoDto todoDto = this.findById(id);
            if (todoDto == null) {
                logSection.log(Level.ERROR, "trigger exception");
                throwBusinessException("E0001", id);
//                throw new ExtendedRuntimeException("Todo not found: " + id)
//                        .withExtendedAttribute("id", id);
            }
            this.todoList.remove(todoDto);
        } finally {
            logSection.leave();
        }
    }

    @Override
    public void completeTodoById(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            TodoDto todoDto = this.findById(id);
            if (todoDto == null) {
                logSection.log(Level.ERROR, "trigger exception");
                throwBusinessException("E0001", id);
            }
            if (todoDto.isCompleted()) {
                throwBusinessException(TodoErrorDefinition.TODO_COMPLETED, id);
            }
            todoDto.setCompleted(true);
        } finally {
            logSection.leave();
        }
    }

    @Override
    public void openTodoById(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            TodoDto todoDto = this.findById(id);
            if (todoDto == null) {
                logSection.log(Level.ERROR, "trigger exception");
                throwBusinessException("E0001", id);
            }
            if (!todoDto.isCompleted()) {
                throwBusinessException("E1002", id);
            }
            todoDto.setCompleted(false);
        } finally {
            logSection.leave();
        }
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        // 设置初始数据
        int count = ThreadLocalRandom.current().nextInt(5, 10);
        for (int i = 0; i < count; i++) {
            TodoDto todoDto = new TodoDto();
            todoDto.setId(counter.incrementAndGet());
            todoDto.setTitle("Todo # " + todoDto.getId());
            todoDto.setCompleted(ThreadLocalRandom.current().nextBoolean());
            this.todoList.add(todoDto);
        }
    }
}

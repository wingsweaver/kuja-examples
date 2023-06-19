package com.example.webmvc.lib.common.controller;

import com.example.webmvc.lib.common.dto.TodoDto;
import com.wingsweaver.kuja.common.boot.context.BusinessContext;
import com.wingsweaver.kuja.common.boot.context.BusinessContextHolder;
import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValue;
import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValueT;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogSection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController extends AbstractTodoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TodoController.class);

    @GetMapping("")
    public ReturnValueT<List<TodoDto>> getTodoList(BusinessContext businessContext) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return super.getTodoListInternal();
        } finally {
            logSection.leave();
        }
    }

    @GetMapping("/{id}")
    public ReturnValueT<TodoDto> getTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return super.getTodoByIdInternal(id);
        } finally {
            logSection.leave();
        }
    }

    @DeleteMapping("/{id}")
    public ReturnValue deleteTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return super.deleteTodoByIdInternal(id);
        } finally {
            logSection.leave();
        }
    }

    @GetMapping("/complete/{id}")
    public ReturnValue completeTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return super.completeTodoByIdInternal(id);
        } finally {
            logSection.leave();
        }
    }

    @GetMapping("/open/{id}")
    public ReturnValue openTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return super.openTodoByIdInternal(id);
        } finally {
            logSection.leave();
        }
    }
}

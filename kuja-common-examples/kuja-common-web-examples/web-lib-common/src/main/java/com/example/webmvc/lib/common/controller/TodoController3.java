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
import org.springframework.web.context.request.async.WebAsyncTask;

import java.util.List;

@RestController
@RequestMapping("/api/todo3")
public class TodoController3 extends AbstractTodoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TodoController3.class);

    @GetMapping("")
    public WebAsyncTask<ReturnValueT<List<TodoDto>>> getTodoList(BusinessContext businessContext) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return new WebAsyncTask<>(super.getTodoListInternalAsync());
        } finally {
            logSection.leave();
        }
    }

    @GetMapping("/{id}")
    public WebAsyncTask<ReturnValueT<TodoDto>> getTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return new WebAsyncTask<>(super.getTodoByIdInternalAsync(id));
        } finally {
            logSection.leave();
        }
    }

    @DeleteMapping("/{id}")
    public WebAsyncTask<ReturnValue> deleteTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return new WebAsyncTask<>(super.deleteTodoByIdInternalAsync(id));
        } finally {
            logSection.leave();
        }
    }

    @GetMapping("/complete/{id}")
    public WebAsyncTask<ReturnValue> completeTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return new WebAsyncTask<>(super.completeTodoByIdInternalAsync(id));
        } finally {
            logSection.leave();
        }
    }

    @GetMapping("/open/{id}")
    public WebAsyncTask<ReturnValue> openTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return new WebAsyncTask<>(super.openTodoByIdInternalAsync(id));
        } finally {
            logSection.leave();
        }
    }
}

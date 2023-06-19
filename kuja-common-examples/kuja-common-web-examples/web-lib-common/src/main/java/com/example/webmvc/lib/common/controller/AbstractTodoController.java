package com.example.webmvc.lib.common.controller;

import com.example.webmvc.lib.common.dto.TodoDto;
import com.example.webmvc.lib.common.service.TodoService;
import com.wingsweaver.kuja.common.boot.context.BusinessContext;
import com.wingsweaver.kuja.common.boot.context.BusinessContextHolder;
import com.wingsweaver.kuja.common.boot.context.BusinessContextMethodWrapper;
import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValue;
import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValueT;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogSection;
import com.wingsweaver.kuja.common.web.controller.AbstractController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.concurrent.Callable;

public abstract class AbstractTodoController extends AbstractController {
    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractTodoController.class);
    @Autowired
    private TodoService todoService;

    protected ReturnValueT<List<TodoDto>> getTodoListInternal() {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return this.success(todoService.getTodoList());
        } finally {
            logSection.leave();
        }
    }

    protected Callable<ReturnValueT<List<TodoDto>>> getTodoListInternalAsync() {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return BusinessContextMethodWrapper.callable(this::getTodoListInternal);
        } finally {
            logSection.leave();
        }
    }

    protected ReturnValueT<TodoDto> getTodoByIdInternal(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return this.success(todoService.getTodoById(id));
        } finally {
            logSection.leave();
        }
    }

    protected Callable<ReturnValueT<TodoDto>> getTodoByIdInternalAsync(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return BusinessContextMethodWrapper.callable(() -> getTodoByIdInternal(id));
        } finally {
            logSection.leave();
        }
    }

    protected ReturnValue deleteTodoByIdInternal(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            todoService.deleteTodoById(id);
            return this.success();
        } finally {
            logSection.leave();
        }
    }

    protected Callable<ReturnValue> deleteTodoByIdInternalAsync(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return BusinessContextMethodWrapper.callable(() -> deleteTodoByIdInternal(id));
        } finally {
            logSection.leave();
        }
    }

    protected ReturnValue completeTodoByIdInternal(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            todoService.completeTodoById(id);
            return this.success();
        } finally {
            logSection.leave();
        }
    }

    protected Callable<ReturnValue> completeTodoByIdInternalAsync(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return BusinessContextMethodWrapper.callable(() -> completeTodoByIdInternal(id));
        } finally {
            logSection.leave();
        }
    }

    protected ReturnValue openTodoByIdInternal(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            todoService.openTodoById(id);
            return this.success();
        } finally {
            logSection.leave();
        }
    }

    protected Callable<ReturnValue> openTodoByIdInternalAsync(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return BusinessContextMethodWrapper.callable(() -> openTodoByIdInternal(id));
        } finally {
            logSection.leave();
        }
    }
}

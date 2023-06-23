package com.example.webmvc.lib.common.controller;

import com.example.webmvc.lib.common.dto.TodoDto;
import com.wingsweaver.kuja.common.boot.context.BusinessContext;
import com.wingsweaver.kuja.common.boot.context.BusinessContextHolder;
import com.wingsweaver.kuja.common.boot.context.BusinessContextMethodWrapper;
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
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/todo4")
public class TodoController4 extends AbstractTodoController {
    private static final Logger LOGGER = LoggerFactory.getLogger(TodoController4.class);

    @GetMapping("")
    public Mono<ReturnValueT<List<TodoDto>>> getTodoList(BusinessContext businessContext) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return this.getTodoListInternalMono();
        } finally {
            logSection.leave();
        }
    }

    protected Mono<ReturnValueT<List<TodoDto>>> getTodoListInternalMono() {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return Mono.fromCallable(BusinessContextMethodWrapper.callable(this::getTodoListInternal));
        } finally {
            logSection.leave();
        }
    }

    @GetMapping("/{id}")
    public Mono<ReturnValueT<TodoDto>> getTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return this.getTodoByIdInternalMono(id);
        } finally {
            logSection.leave();
        }
    }

    protected Mono<ReturnValueT<TodoDto>> getTodoByIdInternalMono(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return Mono.fromCallable(BusinessContextMethodWrapper.callable(() -> getTodoByIdInternal(id)));
        } finally {
            logSection.leave();
        }
    }

    @DeleteMapping("/{id}")
    public Mono<ReturnValue> deleteTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return this.deleteTodoByIdInternalMono(id);
        } finally {
            logSection.leave();
        }
    }

    protected Mono<ReturnValue> deleteTodoByIdInternalMono(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return Mono.fromCallable(BusinessContextMethodWrapper.callable(() -> deleteTodoByIdInternal(id)));
        } finally {
            logSection.leave();
        }
    }

    @GetMapping("/complete/{id}")
    public Mono<ReturnValue> completeTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return this.completeTodoByIdInternalMono(id);
        } finally {
            logSection.leave();
        }
    }

    protected Mono<ReturnValue> completeTodoByIdInternalMono(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return Mono.fromCallable(BusinessContextMethodWrapper.callable(() -> completeTodoByIdInternal(id)));
        } finally {
            logSection.leave();
        }
    }

    @GetMapping("/open/{id}")
    public Mono<ReturnValue> openTodoById(BusinessContext businessContext, @PathVariable("id") Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try (BusinessContextHolder.TempHolder ignored = BusinessContextHolder.with(businessContext)) {
            logSection.log("business context from request = {}", businessContext);
            BusinessContext current = BusinessContextHolder.getCurrent();
            logSection.log("Current business context = {}", current);
            return this.openTodoByIdInternalMono(id);
        } finally {
            logSection.leave();
        }
    }

    protected Mono<ReturnValue> openTodoByIdInternalMono(Long id) {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            BusinessContext businessContext = BusinessContextHolder.getCurrent();
            if (businessContext != null) {
                logSection.log("Current business context = {}", businessContext);
            }
            return Mono.fromCallable(BusinessContextMethodWrapper.callable(() -> openTodoByIdInternal(id)));
        } finally {
            logSection.leave();
        }
    }
}

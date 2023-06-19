package com.example.webmvc.lib.common.errors;

import com.wingsweaver.kuja.common.boot.errordefinition.DefaultErrorDefinition;
import com.wingsweaver.kuja.common.boot.errordefinition.ErrorDefinition;
import com.wingsweaver.kuja.common.boot.errordefinition.ErrorDefinitions;
import org.springframework.stereotype.Component;

@ErrorDefinitions
@Component
public class TodoErrorDefinition {
    public static final ErrorDefinition TODO_COMPLETED = DefaultErrorDefinition.builder()
            .code("E1001").message("Todo item is already completed, id = {}")
            .userTip("{E1001}")
            .build();

    public static final ErrorDefinition TODO_NOT_COMPLETED = DefaultErrorDefinition.builder()
            .code("E1002").message("Todo item is not completed yet, id = {}")
            .userTip("{E1002}")
            .build();
}

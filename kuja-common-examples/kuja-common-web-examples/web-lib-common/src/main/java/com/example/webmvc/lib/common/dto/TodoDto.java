package com.example.webmvc.lib.common.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class TodoDto implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 编号。
     */
    private Long id;

    /**
     * 标题。
     */
    private String title;

    /**
     * 描述。
     */
    private String description;

    /**
     * 是否完成。
     */
    private boolean completed;
}

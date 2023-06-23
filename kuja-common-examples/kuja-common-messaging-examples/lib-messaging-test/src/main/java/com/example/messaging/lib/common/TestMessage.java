package com.example.messaging.lib.common;

import com.wingsweaver.kuja.common.utils.model.AbstractTagsTemps;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestMessage extends AbstractTagsTemps {
    private String id;

    private long timestamp;
}

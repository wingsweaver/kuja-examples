package com.example.kuja.idgen.lib;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wingsweaver.kuja.common.utils.model.AbstractPojo;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class IdRecord extends AbstractPojo {
    private Long id;

    private Parsed parsed;

    @Getter
    @Setter
    public static class Parsed extends AbstractPojo {
        @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZZ")
        private Date timestamp;

        private Long workerId;

        private Long sequenceId;
    }
}

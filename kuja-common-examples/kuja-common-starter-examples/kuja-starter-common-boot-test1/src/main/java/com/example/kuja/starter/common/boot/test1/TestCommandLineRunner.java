package com.example.kuja.starter.common.boot.test1;

import com.wingsweaver.kuja.common.boot.model.AbstractBusinessComponent;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestCommandLineRunner extends AbstractBusinessComponent implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {
        LogUtil.info(LOGGER, "success return value: {}", this.success());
    }
}

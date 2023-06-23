package com.wingsweaver.examples.warmupdemo;

import com.wingsweaver.kuja.common.boot.EnableKujaCommonBoot;
import com.wingsweaver.kuja.common.boot.warmup.WarmUpEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationListener;
import org.springframework.core.Ordered;

@SpringBootApplication
@EnableKujaCommonBoot
public class WarmUpDemoApplication implements ApplicationListener<WarmUpEvent>, CommandLineRunner, Ordered {
    private static final Logger LOGGER = LoggerFactory.getLogger(WarmUpDemoApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(WarmUpDemoApplication.class, args);
    }

    @Override
    public void onApplicationEvent(WarmUpEvent event) {
        LOGGER.info("收到预热事件：{}", event);
    }

    @Override
    public void run(String... args) throws Exception {
        LOGGER.info("Command line runner!");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}

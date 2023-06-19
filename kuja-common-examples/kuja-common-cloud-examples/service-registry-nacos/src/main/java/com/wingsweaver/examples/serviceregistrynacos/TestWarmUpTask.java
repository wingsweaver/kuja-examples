package com.wingsweaver.examples.serviceregistrynacos;

import com.wingsweaver.kuja.common.boot.warmup.WarmUpTask;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogSection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;
import org.springframework.stereotype.Component;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Component
public class TestWarmUpTask implements WarmUpTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestWarmUpTask.class);

    @Override
    public void warmUp() {
        LogSection logSection = LogSection.builder(LOGGER).sectionName("测试预热处理").level(Level.INFO).build();
        logSection.enter();
        try {
            int sleepTime = ThreadLocalRandom.current().nextInt(5, 10);
            Thread.sleep(TimeUnit.SECONDS.toMillis(sleepTime));
        } catch (Exception ex) {
            logSection.fail(ex);
        } finally {
            logSection.leave();
        }
    }
}

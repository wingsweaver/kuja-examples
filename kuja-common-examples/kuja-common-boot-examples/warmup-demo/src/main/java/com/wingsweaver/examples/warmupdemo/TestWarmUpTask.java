package com.wingsweaver.examples.warmupdemo;

import com.wingsweaver.kuja.common.boot.warmup.WarmUpTask;
import com.wingsweaver.kuja.common.utils.logging.slf4j.LogSection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class TestWarmUpTask implements WarmUpTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(TestWarmUpTask.class);

    @Autowired
    private ServerProperties serverProperties;

    @Override
    public void warmUp() {
        LogSection logSection = LogSection.builder(LOGGER).build();
        logSection.enter();
        try {
            RestTemplate restTemplate = new RestTemplate();
            Integer port = serverProperties.getPort();
            if (port == null) {
                port = 8080;
            }
            String url = "http://localhost:" + port + "/actuator";
            logSection.log("warm up url: {}", url);
            restTemplate.getForEntity(url, String.class);
        } catch (Exception ex) {
            logSection.fail(ex);
        } finally {
            logSection.leave();
        }
    }
}

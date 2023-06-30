package com.example.error.reporting.demo;

import com.wingsweaver.kuja.common.boot.model.AbstractConfiguration;
import com.wingsweaver.kuja.common.utils.support.concurrent.ThreadPoolExecutorFactory;
import com.wingsweaver.kuja.common.utils.support.concurrent.ThreadPoolProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;

@Configuration(proxyBeanMethods = false)
public class TestConfiguration extends AbstractConfiguration {
    @Bean(name = "error-report-executor", destroyMethod = "shutdown")
    public ThreadPoolExecutor errorReportExecutor() {
        ThreadPoolProperties properties= new ThreadPoolProperties();
        properties.setThreadName("error-report");
        return ThreadPoolExecutorFactory.threadPoolExecutor(properties);
    }
}

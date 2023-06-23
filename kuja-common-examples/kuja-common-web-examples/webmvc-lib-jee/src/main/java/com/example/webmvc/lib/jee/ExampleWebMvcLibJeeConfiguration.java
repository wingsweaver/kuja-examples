package com.example.webmvc.lib.jee;

import com.example.webmvc.lib.jee.filter.TraceIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleWebMvcLibJeeConfiguration {
    @Bean
    public TraceIdFilter customFilter() {
        return new TraceIdFilter();
    }
}

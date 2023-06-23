package com.example.webmvc.lib.jakarta;

import com.example.webmvc.lib.jakarta.filter.TraceIdFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExampleWebMvcLibJakartaConfiguration {
    @Bean
    public TraceIdFilter customFilter() {
        return new TraceIdFilter();
    }
}

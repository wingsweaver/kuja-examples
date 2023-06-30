package com.example.error.reporting.demo;

import com.wingsweaver.kuja.common.webmvc.jee.EnableKujaCommonWebMvcJee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableKujaCommonWebMvcJee
public class ErrorReportingDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErrorReportingDemoApplication.class, args);
    }

}

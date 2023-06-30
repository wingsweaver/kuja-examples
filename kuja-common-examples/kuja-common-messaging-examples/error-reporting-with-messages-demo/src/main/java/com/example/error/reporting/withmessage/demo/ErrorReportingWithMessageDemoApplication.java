package com.example.error.reporting.withmessage.demo;

import com.wingsweaver.kuja.common.messaging.EnableKujaCommonMessaging;
import com.wingsweaver.kuja.common.webmvc.jee.EnableKujaCommonWebMvcJee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableKujaCommonWebMvcJee
@EnableKujaCommonMessaging
public class ErrorReportingWithMessageDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ErrorReportingWithMessageDemoApplication.class, args);
    }

}

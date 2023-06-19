package com.example.webflux.app.v30x;

import com.example.webflux.lib.common.EnableExampleWebLibFlux;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableExampleWebLibFlux
public class WebfluxApp30xApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebfluxApp30xApplication.class, args);
    }

}

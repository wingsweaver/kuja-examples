package com.example.idgentest6;

import com.example.kuja.idgen.lib.EnableTestLibIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTestLibIdGenerator
public class IdGenTest6Application {

    public static void main(String[] args) {
        SpringApplication.run(IdGenTest6Application.class, args);
    }

}

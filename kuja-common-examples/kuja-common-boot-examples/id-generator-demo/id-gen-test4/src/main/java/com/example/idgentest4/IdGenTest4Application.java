package com.example.idgentest4;

import com.example.kuja.idgen.lib.EnableTestLibIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTestLibIdGenerator
public class IdGenTest4Application {

    public static void main(String[] args) {
        SpringApplication.run(IdGenTest4Application.class, args);
    }

}

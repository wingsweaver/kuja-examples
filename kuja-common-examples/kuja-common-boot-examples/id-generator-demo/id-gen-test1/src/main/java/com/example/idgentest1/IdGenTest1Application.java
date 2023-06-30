package com.example.idgentest1;

import com.example.kuja.idgen.lib.EnableTestLibIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTestLibIdGenerator
public class IdGenTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(IdGenTest1Application.class, args);
    }

}

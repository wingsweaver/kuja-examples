package com.example.idgentest5;

import com.example.kuja.idgen.lib.EnableTestLibIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTestLibIdGenerator
public class IdGenTest5Application {

    public static void main(String[] args) {
        SpringApplication.run(IdGenTest5Application.class, args);
    }

}

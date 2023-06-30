package com.example.idgentest3;

import com.example.kuja.idgen.lib.EnableTestLibIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTestLibIdGenerator
public class IdGenTest3Application {

    public static void main(String[] args) {
        SpringApplication.run(IdGenTest3Application.class, args);
    }

}

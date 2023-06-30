package com.example.idgentest2;

import com.example.kuja.idgen.lib.EnableTestLibIdGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableTestLibIdGenerator
public class IdGenTest2Application {

    public static void main(String[] args) {
        SpringApplication.run(IdGenTest2Application.class, args);
    }

}

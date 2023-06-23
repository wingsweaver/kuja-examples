package com.example.messaging.redisson.test1;

import com.example.messaging.lib.EnableLibMessagingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibMessagingTest
public class MessagingRedissonTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(MessagingRedissonTest1Application.class, args);
    }

}

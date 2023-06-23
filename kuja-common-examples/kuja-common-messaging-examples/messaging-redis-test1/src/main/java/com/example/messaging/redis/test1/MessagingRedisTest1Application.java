package com.example.messaging.redis.test1;

import com.example.messaging.lib.EnableLibMessagingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibMessagingTest
public class MessagingRedisTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(MessagingRedisTest1Application.class, args);
    }

}

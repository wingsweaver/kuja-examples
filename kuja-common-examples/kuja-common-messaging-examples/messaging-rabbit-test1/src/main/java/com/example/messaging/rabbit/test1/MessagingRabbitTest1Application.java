package com.example.messaging.rabbit.test1;

import com.example.messaging.lib.EnableLibMessagingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibMessagingTest
public class MessagingRabbitTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(MessagingRabbitTest1Application.class, args);
    }

}

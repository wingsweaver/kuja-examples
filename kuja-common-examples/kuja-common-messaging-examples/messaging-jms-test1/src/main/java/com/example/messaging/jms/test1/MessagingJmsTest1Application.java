package com.example.messaging.jms.test1;

import com.example.messaging.lib.EnableLibMessagingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibMessagingTest
public class MessagingJmsTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(MessagingJmsTest1Application.class, args);
    }

}

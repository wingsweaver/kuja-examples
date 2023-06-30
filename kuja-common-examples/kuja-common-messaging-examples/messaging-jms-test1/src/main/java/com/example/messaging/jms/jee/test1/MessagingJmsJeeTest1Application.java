package com.example.messaging.jms.jee.test1;

import com.example.messaging.lib.EnableLibMessagingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibMessagingTest
public class MessagingJmsJeeTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(MessagingJmsJeeTest1Application.class, args);
    }

}

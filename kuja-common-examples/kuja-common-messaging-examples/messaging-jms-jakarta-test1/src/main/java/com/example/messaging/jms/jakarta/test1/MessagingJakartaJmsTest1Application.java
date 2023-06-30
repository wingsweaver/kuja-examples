package com.example.messaging.jms.jakarta.test1;

import com.example.messaging.lib.EnableLibMessagingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibMessagingTest
public class MessagingJakartaJmsTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(MessagingJakartaJmsTest1Application.class, args);
    }

}

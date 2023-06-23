package com.example.messaging.kafka.test1;

import com.example.messaging.lib.EnableLibMessagingTest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableLibMessagingTest
public class MessagingKafkaTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(MessagingKafkaTest1Application.class, args);
    }

}

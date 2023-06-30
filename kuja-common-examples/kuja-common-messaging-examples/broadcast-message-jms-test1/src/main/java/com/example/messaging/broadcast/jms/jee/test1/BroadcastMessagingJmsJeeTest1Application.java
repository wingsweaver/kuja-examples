package com.example.messaging.broadcast.jms.jee.test1;

import com.wingsweaver.kuja.common.messaging.EnableKujaCommonMessaging;
import com.wingsweaver.kuja.common.webmvc.jee.EnableKujaCommonWebMvcJee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableKujaCommonMessaging
@EnableKujaCommonWebMvcJee
public class BroadcastMessagingJmsJeeTest1Application {

    public static void main(String[] args) {
        SpringApplication.run(BroadcastMessagingJmsJeeTest1Application.class, args);
    }

}

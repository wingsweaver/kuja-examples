package com.wingsweaver.examples.serviceregistryzookeeper;

import com.wingsweaver.kuja.common.cloud.EnableKujaCommonCloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableKujaCommonCloud
public class SmartServiceRegistryZookeeperApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartServiceRegistryZookeeperApplication.class, args);
    }

}

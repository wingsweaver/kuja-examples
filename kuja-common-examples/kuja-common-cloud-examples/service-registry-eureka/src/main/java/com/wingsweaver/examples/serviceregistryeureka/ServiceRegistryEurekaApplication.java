package com.wingsweaver.examples.serviceregistryeureka;

import com.wingsweaver.kuja.common.cloud.EnableKujaCommonCloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
@EnableKujaCommonCloud
public class ServiceRegistryEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryEurekaApplication.class, args);
    }

}

package com.wingsweaver.examples.serviceregistrynacos;

import com.wingsweaver.kuja.common.cloud.EnableKujaCommonCloud;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableKujaCommonCloud
public class ServiceRegistryNacosApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRegistryNacosApplication.class, args);
    }

}

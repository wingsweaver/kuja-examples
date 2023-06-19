package com.wingsweaver.examples.eurekaclient2;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient("eureka-client-1")
public interface EurekaClient1Service {
    @GetMapping("/test")
    Map<String, Object> test();
}

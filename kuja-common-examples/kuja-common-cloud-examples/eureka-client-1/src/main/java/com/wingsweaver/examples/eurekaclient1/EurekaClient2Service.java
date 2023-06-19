package com.wingsweaver.examples.eurekaclient1;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@FeignClient("eureka-client-2")
public interface EurekaClient2Service {
    @GetMapping("/test")
    Map<String, Object> test();
}

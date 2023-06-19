package com.wingsweaver.examples.serviceregistryeureka;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("test-app")
public interface TestAppService {
    @GetMapping("/test")
    String test();
}

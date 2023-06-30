package com.example.error.reporting.withmessage.demo;


import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValue;
import com.wingsweaver.kuja.common.web.controller.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController extends AbstractController {
    @RequestMapping
    public ReturnValue test(@RequestParam(name = "throws", defaultValue = "false") boolean throwsException) {
        if (throwsException) {
            throw new RuntimeException("This is a test exception");
        }
        return this.success();
    }
}

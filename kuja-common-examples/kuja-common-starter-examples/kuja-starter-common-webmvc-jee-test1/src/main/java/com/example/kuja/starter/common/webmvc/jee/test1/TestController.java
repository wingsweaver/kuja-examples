package com.example.kuja.starter.common.webmvc.jee.test1;

import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValue;
import com.wingsweaver.kuja.common.web.controller.AbstractController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController extends AbstractController {
    @RequestMapping
    public ReturnValue test() {
        return this.success();
    }
}

package com.example.kuja.starter.common.webflux.test1;

import com.wingsweaver.kuja.common.boot.context.BusinessContext;
import com.wingsweaver.kuja.common.boot.returnvalue.ReturnValue;
import com.wingsweaver.kuja.common.web.controller.AbstractController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test")
public class TestController extends AbstractController {
    @GetMapping
    public ReturnValue test(BusinessContext businessContext, @RequestParam(name = "id", required = false) Long id) {
        return this.success();
    }
}

package com.example.kuja.idgen.lib;

import com.wingsweaver.kuja.common.boot.EnableKujaCommonBoot;
import com.wingsweaver.kuja.common.boot.model.AbstractConfiguration;
import com.wingsweaver.kuja.common.utils.support.idgen.LongIdGenerator;
import com.wingsweaver.kuja.common.webmvc.jee.EnableKujaCommonWebMvcJee;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableKujaCommonBoot
@EnableKujaCommonWebMvcJee
@Configuration(proxyBeanMethods = false)
public class TestLibIdGeneratorConfiguration extends AbstractConfiguration {
    @Bean
    public TestController testController(LongIdGenerator longIdGenerator) {
        return new TestController();
    }
}

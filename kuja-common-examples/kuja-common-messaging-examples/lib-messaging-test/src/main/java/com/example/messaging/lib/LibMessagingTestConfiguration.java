package com.example.messaging.lib;

import com.example.messaging.lib.controller.TestController;
import com.example.messaging.lib.messaging.TestDestinationResolver;
import com.example.messaging.lib.messaging.TestHeadersResolver;
import com.example.messaging.lib.messaging.TestMessagePredicate;
import com.example.messaging.lib.messaging.TestPayloadResolver;
import com.example.messaging.lib.messaging.TestPostProcessorResolver;
import com.example.messaging.lib.messaging.TestRoutingKeyResolver;
import com.wingsweaver.kuja.common.messaging.EnableKujaCommonMessaging;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration(proxyBeanMethods = false)
@EnableKujaCommonMessaging
public class LibMessagingTestConfiguration {
    @Bean
    public TestController testController() {
        return new TestController();
    }

    @Bean
    public TestMessagePredicate testMessagePredicate() {
        return new TestMessagePredicate();
    }

    @Bean
    public TestDestinationResolver testDestinationResolver() {
        return new TestDestinationResolver();
    }

    @Bean
    public TestPayloadResolver testPayloadResolver() {
        return new TestPayloadResolver();
    }

    @Bean
    public TestHeadersResolver testHeadersResolver() {
        return new TestHeadersResolver();
    }

    @Bean
    @ConditionalOnClass(name = "org.springframework.messaging.core.MessagePostProcessor")
    public TestPostProcessorResolver testPostProcessorResolver() {
        return new TestPostProcessorResolver();
    }

    @Bean
    public TestRoutingKeyResolver testRoutingKeyResolver() {
        return new TestRoutingKeyResolver();
    }
}

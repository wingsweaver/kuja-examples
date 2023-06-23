package com.example.messaging.lib;

import com.wingsweaver.kuja.common.messaging.EnableKujaCommonMessaging;
import com.wingsweaver.kuja.common.webmvc.EnableKujaCommonWebMvc;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@EnableKujaCommonWebMvc
@EnableKujaCommonMessaging
@Import(LibMessagingTestConfiguration.class)
public @interface EnableLibMessagingTest {
}

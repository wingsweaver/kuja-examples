package com.example.webmvc.lib.jee;

import com.example.webmvc.lib.common.EnableExampleWebLibCommon;
import com.wingsweaver.kuja.common.webmvc.jee.EnableKujaCommonWebMvcJee;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@EnableKujaCommonWebMvcJee
@EnableExampleWebLibCommon
@Import(ExampleWebMvcLibJeeConfiguration.class)
public @interface EnableExampleWebLibJee {
}

package com.example.webmvc.lib.jakarta;

import com.example.webmvc.lib.common.EnableExampleWebLibCommon;
import com.wingsweaver.kuja.common.webmvc.jakarta.EnableKujaCommonWebMvcJakarta;
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
@EnableKujaCommonWebMvcJakarta
@EnableExampleWebLibCommon
@Import(ExampleWebMvcLibJakartaConfiguration.class)
public @interface EnableExampleWebLibJakarta {
}

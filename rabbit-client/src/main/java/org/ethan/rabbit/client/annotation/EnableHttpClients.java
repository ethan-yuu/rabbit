package org.ethan.rabbit.client.annotation;

import org.ethan.rabbit.client.registrar.HttpClientRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/12 11:27
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(value= HttpClientRegistrar.class)
public @interface EnableHttpClients {
    String[] basePackages() default {};
    Class<?>[] basePackageClasses() default {};
}

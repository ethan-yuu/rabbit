package org.ethan.rabbit.client.annotation;

import org.ethan.rabbit.client.enums.HttpClientTypeEnum;
import org.springframework.stereotype.Component;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/14 11:07
 */
@Target(value = ElementType.TYPE)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface HttpClient {
    HttpClientTypeEnum type();
}

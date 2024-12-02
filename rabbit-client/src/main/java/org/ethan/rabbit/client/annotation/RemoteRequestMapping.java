package org.ethan.rabbit.client.annotation;

import org.ethan.rabbit.client.enums.HttpClientTypeEnum;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/13 11:21
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface RemoteRequestMapping {

    String path();

    RequestMethod method();

    HttpClientTypeEnum type() default HttpClientTypeEnum.HTTP_CLIENT;

}

package org.ethan.rabbit.client.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/13 11:24
 */
@Target(value = ElementType.PARAMETER)
@Retention(value = RetentionPolicy.RUNTIME)
@Documented
public @interface RemoteReqHeader {

    String value();

}

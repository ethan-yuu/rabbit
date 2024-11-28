package org.ethan.rabbit.client.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Describe：HttpClient的类型，选择底层的实际调用策略
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/12 10:55
 */
@Getter
@AllArgsConstructor
public enum HttpClientTypeEnum {

    /**
     * 与restTemplate进行整合
     */
    REST_TEMPLATE,

    /**
     * 与webClient进行整合
     */
    WEB_CLIENT,

    /**
     * 与httpclient进行整合
     */
    HTTP_CLIENT;

}

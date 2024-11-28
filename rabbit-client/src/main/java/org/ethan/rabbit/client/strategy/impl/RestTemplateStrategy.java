package org.ethan.rabbit.client.strategy.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.ethan.rabbit.client.annotation.HttpClient;
import org.ethan.rabbit.client.enums.HttpClientTypeEnum;
import org.ethan.rabbit.client.strategy.HttpClientStrategy;
import org.ethan.rabbit.client.utils.RestTemplateUtil;

import java.util.Map;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/15 11:39
 */
@HttpClient(type = HttpClientTypeEnum.REST_TEMPLATE)
@Slf4j
@RequiredArgsConstructor
public class RestTemplateStrategy implements HttpClientStrategy {

    private final RestTemplateUtil restTemplateUtil;

    @Override
    public <T> T doGet(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        if (ObjectUtils.anyNull(url, uriVariables, headers)) {
            throw new RuntimeException(getClass().getSimpleName() + "doGet(...) Param anyNull");
        }
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}", getClass().getSimpleName(), url, uriVariables, headers);
        return restTemplateUtil.doGet(url, uriVariables, headers, responseType).getBody();
    }

    @Override
    public <T> T doPost(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        if (ObjectUtils.anyNull(url, uriVariables, headers, requestBody)) {
            throw new RuntimeException(getClass().getSimpleName() + "doPost(...) Param anyNull");
        }
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}, requestBody: {}", getClass().getSimpleName(), url, uriVariables, headers, requestBody);
        return restTemplateUtil.doPost(url, uriVariables, headers, requestBody, responseType).getBody();
    }

    @Override
    public <T> T doPut(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}, requestBody: {}", getClass().getSimpleName(), url, uriVariables, headers, requestBody);
        if (ObjectUtils.anyNull(url, uriVariables, headers, requestBody)) {
            throw new RuntimeException(getClass().getSimpleName() + "doPut(...) Param anyNull");
        }
        return restTemplateUtil.doPut(url, uriVariables, headers, requestBody, responseType).getBody();
    }

    @Override
    public <T> T doDelete(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        if (ObjectUtils.anyNull(url, uriVariables, headers)) {
            throw new RuntimeException(getClass().getSimpleName() + "doDelete(...) Param anyNull");
        }
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}, requestBody: {}", getClass().getSimpleName(), url, uriVariables, headers);
        return restTemplateUtil.doDelete(url, uriVariables, headers, responseType).getBody();
    }

}

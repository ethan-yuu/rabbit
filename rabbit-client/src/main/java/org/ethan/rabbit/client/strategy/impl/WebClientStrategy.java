package org.ethan.rabbit.client.strategy.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.ethan.rabbit.client.annotation.HttpClient;
import org.ethan.rabbit.client.enums.HttpClientTypeEnum;
import org.ethan.rabbit.client.strategy.HttpClientStrategy;
import org.ethan.rabbit.client.utils.WebClientUtil;

import java.util.Map;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/14 11:07
 */
@HttpClient(type = HttpClientTypeEnum.WEB_CLIENT)
@Slf4j
@RequiredArgsConstructor
public class WebClientStrategy implements HttpClientStrategy {

    private final WebClientUtil webClientUtil;

    @Override
    public <T> T doGet(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}", getClass().getSimpleName(), url, uriVariables, headers);
        if (ObjectUtils.anyNull(url, uriVariables, headers)) {
            throw new RuntimeException(getClass().getSimpleName() + "doGet(...) Param anyNull");
        }
        return webClientUtil.doGet(url, uriVariables, headers, responseType);
    }

    @Override
    public <T> T doPost(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}, requestBody: {}", getClass().getSimpleName(), url, uriVariables, headers, requestBody);
        if (ObjectUtils.anyNull(url, uriVariables, headers, requestBody)) {
            throw new RuntimeException(getClass().getSimpleName() + "doPost(...) Param anyNull");
        }
        return webClientUtil.doPost(url, uriVariables, headers, requestBody, responseType);
    }

    @Override
    public <T> T doPut(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        if (ObjectUtils.anyNull(url, uriVariables, headers, requestBody)) {
            throw new RuntimeException(getClass().getSimpleName() + "doPut(...) Param anyNull");
        }
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}, requestBody: {}", getClass().getSimpleName(), url, uriVariables, headers, requestBody);
        return webClientUtil.doPut(url, uriVariables, headers, requestBody, responseType);
    }

    @Override
    public <T> T doDelete(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        if (ObjectUtils.anyNull(url, uriVariables, headers)) {
            throw new RuntimeException(getClass().getSimpleName() + "doDelete(...) Param anyNull");
        }
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}, requestBody: {}", getClass().getSimpleName(), url, uriVariables, headers);
        return webClientUtil.doDelete(url, uriVariables, headers, responseType);
    }

}

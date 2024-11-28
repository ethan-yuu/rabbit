package org.ethan.rabbit.client.strategy.impl;

import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.ethan.rabbit.client.annotation.HttpClient;
import org.ethan.rabbit.client.enums.HttpClientTypeEnum;
import org.ethan.rabbit.client.strategy.HttpClientStrategy;
import org.ethan.rabbit.client.utils.CommonUtils;
import org.ethan.rabbit.client.utils.HttpClientUtil;

import java.util.Map;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/18 18:07
 */
@HttpClient(type = HttpClientTypeEnum.HTTP_CLIENT)
@RequiredArgsConstructor
@Slf4j
public class CloseableHttpClientStrategy implements HttpClientStrategy {

    private final HttpClientUtil httpClientUtil;

    @Override
    public <T> T doGet(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        if (ObjectUtils.anyNull(url, uriVariables, headers)) {
            throw new RuntimeException(getClass().getSimpleName() + "doGet(...) Param anyNull");
        }
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}", getClass().getSimpleName(), url, uriVariables, headers);
        Map<String, String> stringMap = CommonUtils.convertToStringMap(uriVariables);
        return JSONObject.parseObject(httpClientUtil.doGet(url, stringMap, headers), responseType);
    }

    @Override
    public <T> T doPost(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        if (ObjectUtils.anyNull(url, uriVariables, headers, requestBody)) {
            throw new RuntimeException(getClass().getSimpleName() + "doPost(...) Param anyNull");
        }
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}, requestBody: {}", getClass().getSimpleName(), url, uriVariables, headers, requestBody);
        Map<String, String> stringMap = CommonUtils.convertToStringMap(uriVariables);
        return JSONObject.parseObject(httpClientUtil.doPost(url, stringMap, headers, requestBody), responseType);
    }

    @Override
    public <T> T doPut(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}, requestBody: {}", getClass().getSimpleName(), url, uriVariables, headers, requestBody);
        if (ObjectUtils.anyNull(url, uriVariables, headers, requestBody)) {
            throw new RuntimeException(getClass().getSimpleName() + "doPut(...) Param anyNull");
        }
        Map<String, String> stringMap = CommonUtils.convertToStringMap(uriVariables);
        return JSONObject.parseObject(httpClientUtil.doPut(url, stringMap, headers, requestBody), responseType);
    }

    @Override
    public <T> T doDelete(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        if (ObjectUtils.anyNull(url, uriVariables, headers)) {
            throw new RuntimeException(getClass().getSimpleName() + "doDelete(...) Param anyNull");
        }
        log.info("HttpClient send info, use: {}, url: {}, uriVariables: {}, headers: {}, requestBody: {}", getClass().getSimpleName(), url, uriVariables, headers);
        Map<String, String> stringMap = CommonUtils.convertToStringMap(uriVariables);
        return JSONObject.parseObject(httpClientUtil.doDelete(url, stringMap, headers), responseType);
    }

}

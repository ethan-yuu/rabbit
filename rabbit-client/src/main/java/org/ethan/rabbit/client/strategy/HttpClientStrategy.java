package org.ethan.rabbit.client.strategy;

import java.util.Map;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/14 11:04
 */
public interface HttpClientStrategy {

    <T> T doGet(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType);

    <T> T doPost(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType);

    <T> T doPut(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType);

    <T> T doDelete(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType);

}

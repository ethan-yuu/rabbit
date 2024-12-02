package org.ethan.rabbit.client.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/20 10:53
 */
@Component
@Slf4j
public class RestTemplateUtil {

    @Autowired
    private  RestTemplate restTemplate;

    /**========================== GET ==========================**/

    public <T> ResponseEntity<T> doGet(String url, Map<String, ?> uriVariables, Class<T> responseType) {
        return restTemplate.getForEntity(url, responseType, uriVariables);
    }

    public <T> ResponseEntity<T> doGet(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(headers);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> request = new HttpEntity<>(httpHeaders);
        return this.exchange(url, HttpMethod.GET, request, responseType, uriVariables);
    }

    /**========================== POST ==========================**/

    public <T> ResponseEntity<T> doPost(String url, Map<String, ?> uriVariables, Object requestBody, Class<T> responseType) {
        return restTemplate.postForEntity(url, uriVariables, null, requestBody, responseType);
    }

    public <T> ResponseEntity<T> doPost(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(headers);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> request = new HttpEntity<>(requestBody, httpHeaders);
        return this.exchange(url, HttpMethod.POST, request, responseType, uriVariables);
    }


    /**========================== PUT ==========================**/

    public <T> ResponseEntity<T> doPut(String url, Map<String, ?> uriVariables, Object requestBody, Class<T> responseType) {
        return this.doPut(url, uriVariables, null, requestBody, responseType);
    }

    public <T> ResponseEntity<T> doPut(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(headers);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> requestEntity = new HttpEntity<>(requestBody, httpHeaders);
        return this.exchange(url, HttpMethod.PUT, requestEntity, responseType, uriVariables);
    }

    /**========================== DELETE ==========================**/

    public <T> ResponseEntity<T> doDelete(String url, Map<String, ?> uriVariables, Class<T> responseType) {
        return this.doDelete(url, uriVariables, null, responseType);
    }

    public <T> ResponseEntity<T> doDelete(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAll(headers);
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<?> requestEntity = new HttpEntity<>(httpHeaders);
        return this.exchange(url, HttpMethod.DELETE, requestEntity, responseType, uriVariables);
    }

    /**========================== 基础通用类 ==========================**/

    /**
     * 通用调用方式
     *
     * @param url           请求URL
     * @param method        请求方法类型
     * @param requestEntity 请求头和请求体封装对象
     * @param responseType  返回对象类型
     * @param uriVariables  URL中的变量，按顺序依次对应
     * @return
     * @param <T> 响应对象封装类
     */
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) {
        return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
    }

    /**
     * 通用调用方式
     *
     * @param url           请求URL
     * @param method        请求方法类型
     * @param requestEntity 请求头和请求体封装对象
     * @param responseType  返回对象类型
     * @param uriVariables  URL中的变量，按顺序依次对应
     * @return
     * @param <T> 响应对象封装类
     */
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method, HttpEntity<?> requestEntity, Class<T> responseType, Map<String, ?> uriVariables) {
        return restTemplate.exchange(url, method, requestEntity, responseType, uriVariables);
    }

    /**
     * 获取 restTemplate 实例对象
     * @return
     */
    public RestTemplate getRestTemplate(){
        return restTemplate;
    }

}

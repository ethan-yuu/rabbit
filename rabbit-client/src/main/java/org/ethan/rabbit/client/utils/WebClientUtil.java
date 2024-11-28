package org.ethan.rabbit.client.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.function.Function;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/20 10:55
 */
@Component
@Slf4j
public class WebClientUtil {

    @Autowired
    private WebClient webClient;

    /**========================== GET ==========================**/

    public <T> T doGet(String url, Map<String, ?> uriVariables, Class<T> responseType) {
        return doGet(url, uriVariables, null, responseType);
    }

    public <T> T doGet(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        WebClient.RequestHeadersSpec uri = webClient.get().uri(url, uriVariables)
                .accept(MediaType.APPLICATION_JSON);
        addHeaders(headers, uri);
        return uri.retrieve().bodyToMono(responseType).block();
    }

    /**========================== POST ==========================**/

    public <T> T doPost(String url, Map<String, ?> uriVariables, Object requestBody, Class<T> responseType) {
        return doPost(url, uriVariables, null, requestBody, responseType);
    }

    public <T> T doPost(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        WebClient.RequestHeadersSpec uri = webClient.post().uri(url, uriVariables)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(requestBody), Object.class);
        addHeaders(headers, uri);
        return uri.retrieve().bodyToMono(responseType).block();
    }

    /**========================== PUT ==========================**/

    public <T> T doPut(String url, Map<String, ?> uriVariables, T requestBody, Class<T> responseType) {
        return doPut(url, uriVariables, null, requestBody, responseType);
    }

    public <T> T doPut(String url, Map<String, ?> uriVariables, Map<String, String> headers, Object requestBody, Class<T> responseType) {
        WebClient.RequestHeadersSpec uri = webClient.put().uri(url, uriVariables)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(requestBody), Object.class);
        addHeaders(headers, uri);
        return uri.retrieve().bodyToMono(responseType).block();
    }

    /**========================== DELETE ==========================**/

    public <T> T doDelete(String url, Map<String, ?> uriVariables, Class<T> responseType) {
        return doDelete(url, uriVariables, null, responseType);
    }

    public <T> T doDelete(String url, Map<String, ?> uriVariables, Map<String, String> headers, Class<T> responseType) {
        WebClient.RequestHeadersSpec uri = webClient.delete().uri(url, uriVariables)
                .accept(MediaType.APPLICATION_JSON);
        addHeaders(headers, uri);
        return uri.retrieve().bodyToMono(responseType).block();
    }

    private void addHeaders(Map<String, String> headers, WebClient.RequestHeadersSpec uri) {
        if (!CollectionUtils.isEmpty(headers)) {
            headers.entrySet().stream()
                    .forEach(
                            entry -> uri.header(entry.getKey(), entry.getValue())
                    );
        }
    }

}

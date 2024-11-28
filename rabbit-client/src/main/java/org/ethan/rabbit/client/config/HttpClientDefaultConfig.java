package org.ethan.rabbit.client.config;

import lombok.Data;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.ExchangeFunction;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.nio.charset.Charset;
import java.util.List;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/11 15:30
 */
@Data
@Configuration
public class HttpClientDefaultConfig {

    /**
     * 最大连接数
     */
    private Integer maxTotal = 300;

    /**
     * 每个host的最大连接
     */
    private Integer defaultMaxPerRoute = 50;

    /**
     * 连接超时时间
     */
    private Integer connectTimeout = 1000;

    /**
     * 请求超时时间
     */
    private Integer connectionRequestTimeout = 500;

    /**
     * 响应超时时间
     */
    private Integer socketTimeout = 5000;

    /**
     * HttpClient 连接池
     *
     * @return
     */
    @Bean
    public HttpClientConnectionManager httpClientConnectionManager() {
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        connectionManager.setMaxTotal(maxTotal);
        connectionManager.setDefaultMaxPerRoute(defaultMaxPerRoute);
        return connectionManager;
    }

    /**
     * 注册 RequestConfig
     *
     * @return
     */
    @Bean
    public RequestConfig requestConfig() {
        return RequestConfig.custom().setConnectTimeout(connectTimeout)
                .setConnectionRequestTimeout(connectionRequestTimeout)
                .setSocketTimeout(socketTimeout)
                .build();
    }

    /**
     * 注册HttpClient（ClientHttpRequestFactory）
     *
     * @param manager
     * @param config
     * @return
     */
    @Bean
    public CloseableHttpClient httpClient(HttpClientConnectionManager manager, RequestConfig config) {
        return HttpClientBuilder.create().setConnectionManager(manager).setDefaultRequestConfig(config)
                .build();
    }


    /**
     * 初始化 HttpClientTypeEnum.HTTP_CLIENT 的连接方式
     *
     * @param httpClient
     * @return
     */
    @Bean
    public ClientHttpRequestFactory requestFactory(CloseableHttpClient httpClient) {
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }

    /**==============================================================================================================**/

    /**
     * 初始化 HttpClientTypeEnum.REST_TEMPLATE 的连接方式
     *
     * @param requestFactory
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(ClientHttpRequestFactory requestFactory) {
        RestTemplate template = new RestTemplate(requestFactory);
        List<HttpMessageConverter<?>> list = template.getMessageConverters();
        for (HttpMessageConverter<?> mc : list) {
            if (mc instanceof StringHttpMessageConverter) {
                ((StringHttpMessageConverter) mc).setDefaultCharset(Charset.forName("UTF-8"));
            }
        }
        return template;
    }

    /**==============================================================================================================**/

    /**
     * 初始化 HttpClientTypeEnum.WEB_CLIENT 的连接方式
     *
     * @return
     */
    @Bean
    public WebClient webClient() {
        return WebClient.create();
    }

}

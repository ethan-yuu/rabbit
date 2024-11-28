package org.ethan.rabbit.client.strategy.context;

import org.apache.commons.collections4.CollectionUtils;
import org.ethan.rabbit.client.annotation.HttpClient;
import org.ethan.rabbit.client.common.util.SpringContextHolder;
import org.ethan.rabbit.client.enums.HttpClientTypeEnum;
import org.ethan.rabbit.client.strategy.HttpClientStrategy;
import org.reflections.Reflections;
import org.springframework.util.Assert;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/14 11:03
 */
public enum HttpClientContext {

    INSTANCE;

    private Map<HttpClientTypeEnum, Class<HttpClientStrategy>> strategyMap = new ConcurrentHashMap<>();


    public HttpClientStrategy getInstance(HttpClientTypeEnum type) {
        return this.getHttpClientStrategyByType(type);
    }

    public <T> void init(String packageName) {
        Reflections reflections = new Reflections(packageName);
        // 会去扫描被 @HttpClient 标注的类
        Set<Class<?>> clzSet = reflections.getTypesAnnotatedWith(HttpClient.class);
        if (CollectionUtils.isNotEmpty(clzSet)) {
            for (Class<?> clz : clzSet) {
                HttpClient httpClient = clz.getAnnotation(HttpClient.class);
                strategyMap.put(httpClient.type(), (Class<HttpClientStrategy>) clz);
            }
        }
    }

    private HttpClientStrategy getHttpClientStrategyByType(HttpClientTypeEnum type) {
        Class<HttpClientStrategy> clz = strategyMap.get(type);
        Assert.notNull(clz, "type:" + type + "can not found class,please checked");
        return SpringContextHolder.getBean(clz);
    }


}

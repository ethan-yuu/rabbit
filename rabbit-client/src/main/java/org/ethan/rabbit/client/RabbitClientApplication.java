package org.ethan.rabbit.client;

import org.ethan.rabbit.client.annotation.EnableHttpClients;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Describe：
 *
 * @Author： ethan-yuu
 * @Date： 2024/11/18 17:53
 */
@SpringBootApplication
@EnableHttpClients
public class RabbitClientApplication {


    // TODO https://cloud.tencent.com/developer/article/1537173
    // client 工具封装

    // httpclient4.5 https://hc.apache.org/httpcomponents-client-5.4.x/quickstart.html
    // RestTemplate https://docs.spring.io/spring-framework/docs/current/javadoc-api/org/springframework/web/client/RestTemplate.html
    // webClient https://docs.spring.io/spring-framework/docs/5.1.2.RELEASE/spring-framework-reference/web-reactive.html#webflux

    public static void main(String[] args) {
        SpringApplication.run(RabbitClientApplication.class);
    }

}

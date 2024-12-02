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

    public static void main(String[] args) {
        SpringApplication.run(RabbitClientApplication.class);
    }

}

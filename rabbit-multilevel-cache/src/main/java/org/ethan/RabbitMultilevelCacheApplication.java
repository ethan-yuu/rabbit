package org.ethan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitMultilevelCacheApplication {

    public static void main(String[] args) {
        // TODO 多级缓存策略 咖啡因 redis
        // https://blog.csdn.net/A_art_xiang/article/details/134573115
        // https://rewind.show/2022/03/26/%E4%B8%AD%E9%97%B4%E4%BB%B6/%E7%BC%93%E5%AD%98/%E6%9C%AC%E5%9C%B0%E7%BC%93%E5%AD%98Caffeine/
        SpringApplication.run(RabbitMultilevelCacheApplication.class);
    }

}
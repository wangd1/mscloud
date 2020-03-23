package com.wang.scalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dwang
 * @create 2020-03-08 20:07
 */

@SpringBootApplication
@EnableDiscoveryClient
public class NacosConsumerApplication9990 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConsumerApplication9990.class,args);
    }
}

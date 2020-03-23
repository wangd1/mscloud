package com.wang.scalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dwang
 * @create 2020-03-08 19:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication9902 {
    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication9902.class,args);
    }
}

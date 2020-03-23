package com.wang.scalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dwang
 * @create 2020-03-08 19:31
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosProviderApplication9901 {

    public static void main(String[] args) {
        SpringApplication.run(NacosProviderApplication9901.class,args);
    }
}

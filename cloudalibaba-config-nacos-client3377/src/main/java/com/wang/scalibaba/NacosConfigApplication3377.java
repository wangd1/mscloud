package com.wang.scalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author dwang
 * @create 2020-03-09 9:07
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigApplication3377 {

    public static void main(String[] args) {
        SpringApplication.run(NacosConfigApplication3377.class,args);
    }
}

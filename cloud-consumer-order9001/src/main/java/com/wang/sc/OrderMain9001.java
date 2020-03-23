package com.wang.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author dwang
 * @create 2020-03-05 15:20
 */
@SpringBootApplication
@EnableEurekaClient
//指定自定义负载均衡算法
//@RibbonClient(name = "CLOUD-PAYMENT-SERVICE",configuration = ProfileRule.class)
public class OrderMain9001 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain9001.class,args);
    }
}

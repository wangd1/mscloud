package com.wang.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dwang
 * @create 2020-03-06 17:22
 */
@SpringBootApplication
//@EnableEurekaClient
@EnableFeignClients
@EnableCircuitBreaker //hystrix断路器
@EnableHystrixDashboard  //hystrix dashboard监控页面，同时其他需要监控的服务都要加actuator依赖
public class OrderFeignHystrixMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeignHystrixMain9001.class,args);
    }
}

package com.wang.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author dwang
 * @create 2020-03-06 14:52
 */
@SpringBootApplication
@EnableFeignClients   //激活feign
public class OrderFeginMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(OrderFeginMain9001.class,args);
    }
}

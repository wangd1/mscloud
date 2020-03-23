package com.wang.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author dwang
 * @create 2020-03-05 14:13
 */
@SpringBootApplication
@EnableEurekaClient  //开启eurekaclient,注册到服务中心
public class PaymentMain8002 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8002.class,args);
    }
}

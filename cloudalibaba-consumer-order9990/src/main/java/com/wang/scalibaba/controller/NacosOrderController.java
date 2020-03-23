package com.wang.scalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author dwang
 * @create 2020-03-08 20:14
 */
@RestController
@Slf4j
public class NacosOrderController {

    @Value("${service-url.nacos-user-service}")
    private String serviceUrl;

    @Resource
    private RestTemplate mRestTemplate;

    @GetMapping("/consumer/echo/{value}")
    public String echo(@PathVariable("value") String value){

        return mRestTemplate.getForObject(serviceUrl+"/echo/"+value, String.class);

    }
}

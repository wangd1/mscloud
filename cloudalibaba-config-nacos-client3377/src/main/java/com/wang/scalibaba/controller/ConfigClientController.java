package com.wang.scalibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dwang
 * @create 2020-03-09 9:08
 */
@RestController
@RefreshScope  //支持nacos的动态刷新
public class ConfigClientController {

    @Value("${config.info}")
    private String info;

    @GetMapping("/config/info")
    public String getConfigInfo(){
        return info;
    }
}

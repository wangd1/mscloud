package com.wang.sc.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dwang
 * @create 2020-03-07 15:03
 */
@RestController
@RefreshScope //用于动态刷新配置文件
public class ConfigInfoController {

    @Value("${config.info}")
    private String info;

    @Value("${server.port}")
    private String port;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return info+" port:"+port;
    }
}

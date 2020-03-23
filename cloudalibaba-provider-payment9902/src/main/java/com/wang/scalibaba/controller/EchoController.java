package com.wang.scalibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author dwang
 * @create 2020-03-08 19:56
 */
@RestController
@Slf4j
public class EchoController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/echo/{value}")
    public String echo(@PathVariable("value") String value){

        return "Hello Nacos Discovery "+value+"\t in "+serverPort;

    }
}

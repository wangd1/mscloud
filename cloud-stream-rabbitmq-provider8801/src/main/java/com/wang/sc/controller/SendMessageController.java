package com.wang.sc.controller;

import com.wang.sc.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dwang
 * @create 2020-03-08 12:14
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider mMessageProvider;

    @GetMapping("/sendMessage")
    public String sendMessage(){
        return mMessageProvider.send();
    }

}

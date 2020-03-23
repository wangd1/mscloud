package com.wang.sc.controller;

import com.wang.sc.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dwang
 * @create 2020-03-06 16:55
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService mPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public  String getPaymentInfoOK(@PathVariable("id") Integer id){
        String result = mPaymentService.paymentInfoOK(id);
        log.info("*********result:"+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public  String getPaymentInfoTimeout(@PathVariable("id") Integer id){
        String result = mPaymentService.paymentInfoTimeout(id);
        log.info("*********result:"+result);
        return result;
    }

    //========服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = mPaymentService.paymentCircuitBreaker(id);
        log.info("********result:"+result);
        return result;
    }
}

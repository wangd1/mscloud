package com.wang.sc.controller;

import com.wang.sc.entity.Payment;
import com.wang.sc.entity.Results;
import com.wang.sc.service.PaymentFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dwang
 * @create 2020-03-06 14:59
 */
@RestController
@Slf4j
public class OrderFeignController {

    @Resource
    private PaymentFeignService mPaymentFeignService;

    @PostMapping("/consumer/payment/add")
    public Results add(Payment payment){
        return mPaymentFeignService.add(payment);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public Results getPaymentById(@PathVariable("id") Long id){
        return mPaymentFeignService.get(id);
    }

    @GetMapping("/consumer/payment/list")
    public Results list(Payment payment){
        return mPaymentFeignService.list(payment);
    }

    @GetMapping("/consumer/payment/timeout")
    public String getPaymentTimeout(){
        return mPaymentFeignService.getPaymentTimeout();
    }

}

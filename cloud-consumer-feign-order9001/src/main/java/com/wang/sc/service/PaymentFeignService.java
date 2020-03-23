package com.wang.sc.service;

import com.wang.sc.entity.Payment;
import com.wang.sc.entity.Results;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
//指定微服务
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    //Results<Payment> add(Payment payment);
    @PostMapping("/payment/add")
    public Results add(Payment payment);

    //Results<Payment> getPaymentById(@Param("id") Long id);
    @GetMapping("/payment/get/{id}")
    public Results<Payment> get(@PathVariable("id") Long id);

    //Results<Payment> list(com.wang.sc.entity.Payment payment);

    /**
     * feign传递参数，@pathvariable只能传递基本数据
     * 如果是get请求，需要使用@RequestParam指定名称，且不能传递对象
     * 如果是post请求传递对象，接收端需要使用@RequestBody注解接收
     * @param payment
     * @return
     */
    @GetMapping("/payment/list")
    public Results list(@RequestParam("payment") Payment payment);

    /**
     * 模拟超时
     * @return
     */
    @GetMapping("/payment/timeout")
    public String getPaymentTimeout();
}

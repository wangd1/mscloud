package com.wang.sc.controller;

import com.wang.sc.entity.Payment;
import com.wang.sc.entity.Results;
import com.wang.sc.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author dwang
 * @create 2020-03-05 14:42
 */
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService mPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/payment/add")
    public Results add(@RequestBody Payment payment){
        int result = mPaymentService.add(payment);
        log.info("-----插入结果："+result);
        if(result>0){
            return new Results(200,"插入结果成功"+serverPort,payment);
        }
        return new Results(444,"插入数据库失败!"+serverPort);
    }/**/

    @GetMapping("/payment/get/{id}")
    public Results<Payment> get(@PathVariable Long id){

        Payment payment = mPaymentService.getPaymentById(id);
        log.info(id+"查成功");
        if(payment!=null){
            return new Results(200, "获取成功"+serverPort,payment);
        }else{
            return new Results(404, "未查询到此id:"+id);
        }
    }

    @GetMapping("/payment/list")
    public Results list(Payment payment){
        List<Payment> list = mPaymentService.list(payment);
        return new Results(200, "获取成功"+serverPort,list);
    }

    @GetMapping("/payment/lb")
    public String getLb(){
        return serverPort;
    }

    @GetMapping("/payment/timeout")
    public String getPaymentTimeout(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}

package com.wang.sc.controller;

import com.wang.sc.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author dwang
 * @create 2020-03-06 17:26
 */
@RestController
@Slf4j
//@DefaultProperties(defaultFallback="paymentGlobalFallbackMethod")
public class OrderHtstrixController {

    @Resource
    private PaymentHystrixService mPaymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public  String getPaymentInfoOK(@PathVariable("id") Integer id){
        //try{
        //    int i=10/0;
        //}catch (Exception e){
        //    throw new HystrixBadRequestException("11111");
        //}
        return mPaymentHystrixService.getPaymentInfoOK(id);
    }

    /**
     * 客户端服务降级
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    //@HystrixCommand(fallbackMethod = "getPaymentInfoTimeoutHandler",commandProperties = {
    //        @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    //})
    //加了fallbackmethod，就找自己的，否则找全局的
    //@HystrixCommand
    public  String getPaymentInfoTimeout(@PathVariable("id") Integer id){
        //int i = 10/0;
        return mPaymentHystrixService.getPaymentInfoTimeout(id);
    }

    //服务降级，指定兜底处理
    public  String getPaymentInfoTimeoutHandler(@PathVariable("id") Integer id){
        return "我是消费者9001，对方支付系统繁忙，请稍后重试或操作错误！";
    }

    //全局兜底方法
    public String paymentGlobalFallbackMethod(){
        return "Global异常处理信息，请稍候再试！";
    }
}

package com.wang.sc.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {

    /**
     * 正常访问ok
     * @param id
     * @return
     */
    public String paymentInfoOK(Integer id){
        return "线程池："+Thread.currentThread().getName()+" paymentInfoOK，id: "+id;
    }

    /**
     * 异常访问err
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value = "5000")
    })
    public String paymentInfoTimeout(Integer id){
        int num = 3;
        //int n = 10/0;
        try {
            TimeUnit.SECONDS.sleep(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池："+Thread.currentThread().getName()+" paymentInfoTimeout，id: "+id;
    }

    //服务降级，兜底处理
    public String paymentInfoTimeoutHandler(Integer id){
        return "线程池："+Thread.currentThread().getName()+" 系统繁忙，请稍后再试"+id+"哭哭";
    }

    //============服务熔断
    //那些HystrixProperty参数是在HystrixCommandProperties类中定义的
    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerHandler",commandProperties = {
            @HystrixProperty(name="circuitBreaker.enabled",value = "true"),//是否开启断路器
            @HystrixProperty(name="circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name="circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name="circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少跳闸
    })
    public String paymentCircuitBreaker(Integer id){

        if(id<0){
            throw new RuntimeException("id不能为负数");
        }
        String serialNum = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+" 调用成功，流水号："+serialNum;

    }

    public String paymentCircuitBreakerHandler(Integer id){

        return "id不能为负数，请稍候重试！！！id:"+id;

    }

}

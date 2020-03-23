package com.wang.sc.controller;

import com.wang.sc.entity.Payment;
import com.wang.sc.entity.Results;
import com.wang.sc.lb.LoadBalance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author dwang
 * @create 2020-03-05 15:27
 */
@RestController
public class OrderController {

    //private static final String PAYMENT_URL = "http://localhost:8001";
    private static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Autowired
    private RestTemplate mRestTemplate;

    @Autowired
    private LoadBalance loadBalance;

    @Autowired
    private DiscoveryClient discoveryClient;

    @PostMapping("/consumer/payment/add")
    public Results add(Payment payment){
        return mRestTemplate.postForObject(PAYMENT_URL+"/payment/add", payment,Results.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public Results getPaymentById(@PathVariable("id") Long id){
        return mRestTemplate.getForObject(PAYMENT_URL+"/payment/get/"+id,Results.class);
    }

    @GetMapping("/consumer/payment/list")
    public Results list(Payment payment){
        return mRestTemplate.getForObject(PAYMENT_URL+"/payment/list", Results.class);
    }


    /**
     * getForObject返回json串
     * getForEntity返回ResponseEntity实体对象，包含header,body,statusCode等
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public Results getPaymentById2(@PathVariable("id") Long id){
        ResponseEntity<Results> forEntity = mRestTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, Results.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            return forEntity.getBody();
        }else{
            return new Results(404, "未查询到-"+id);
        }
    }

    @GetMapping("/consumer/payment/lb")
    public String getPaymentLB(){
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances==null||instances.size()<=0) {
            return null;
        }
        ServiceInstance instance = loadBalance.instance(instances);
        URI uri = instance.getUri();
        return mRestTemplate.getForObject(uri.toString() + "/payment/lb", String.class);
    }

    @GetMapping("/consumer/payment/zipkin")
    public String paymentZipkin(){
        return mRestTemplate.getForObject("http://localhost:8001/payment/zipkin", String.class);
    }
}

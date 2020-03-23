package com.wang.sc.service;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {

    public int add(com.wang.sc.entity.Payment payment);

    public com.wang.sc.entity.Payment getPaymentById(@Param("id") Long id);

    public List<com.wang.sc.entity.Payment> list(com.wang.sc.entity.Payment payment);
}

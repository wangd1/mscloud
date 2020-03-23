package com.wang.sc.service;

import com.wang.sc.entity.Payment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PaymentService {

    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public List<Payment> list(Payment payment);
}

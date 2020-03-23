package com.wang.sc.dao;

import com.wang.sc.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PaymentDao {

    public int add(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

    public List<Payment> list(Payment payment);
}

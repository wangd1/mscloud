package com.wang.sc.service.impl;

import com.wang.sc.dao.PaymentDao;
import com.wang.sc.entity.Payment;
import com.wang.sc.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author dwang
 * @create 2020-03-05 14:40
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao mPaymentDao;

    public int add(Payment payment) {
        return mPaymentDao.add(payment);
    }

    public Payment getPaymentById(Long id) {
        return mPaymentDao.getPaymentById(id);
    }

    public List<Payment> list(Payment payment) {
        return mPaymentDao.list(payment);
    }
}

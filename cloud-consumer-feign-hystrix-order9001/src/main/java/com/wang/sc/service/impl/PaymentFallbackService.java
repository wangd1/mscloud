package com.wang.sc.service.impl;

import com.wang.sc.service.PaymentHystrixService;
import org.springframework.stereotype.Component;

/**
 * @author dwang
 * @create 2020-03-06 18:35
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService {
    @Override
    public String getPaymentInfoOK(Integer id) {
        return "PaymentFallbackService fallback--getPaymentInfoOK";
    }

    @Override
    public String getPaymentInfoTimeout(Integer id) {
        return "PaymentFallbackService fallback--getPaymentInfoTimeout";
    }
}

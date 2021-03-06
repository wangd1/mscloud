package com.wang.sc.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author dwang
 * @create 2020-03-06 14:19
 */
@Component
public class LoadBalanceImpl implements LoadBalance{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    private final int getAndIncrement(){
        int current;
        int next;
        do{
            current = atomicInteger.get();
            next = current>Integer.MAX_VALUE?0:current+1;
        }while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println("--------next:"+next);
        return next;
    }


    @Override
    public ServiceInstance instance(List<ServiceInstance> serviceInstances) {
        int index = getAndIncrement()%serviceInstances.size();
        return serviceInstances.get(index);
    }
}

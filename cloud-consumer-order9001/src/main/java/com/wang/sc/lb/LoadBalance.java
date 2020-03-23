package com.wang.sc.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface LoadBalance {

    ServiceInstance instance(List<ServiceInstance> serviceInstances);

}

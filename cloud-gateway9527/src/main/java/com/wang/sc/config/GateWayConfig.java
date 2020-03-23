package com.wang.sc.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dwang
 * @create 2020-03-07 12:30
 */
@Configuration
public class GateWayConfig {

    /**
     * 代码配置路由
     * @param builder
     * @return
     */
    @Bean
    public RouteLocator customGateWay(RouteLocatorBuilder builder){
        RouteLocatorBuilder.Builder routes = builder.routes();

        routes.route("path_custom_uri",
                r->r.path("/guonei")
                        .uri("http://news.baidu.com/guonei"))
                .build();
        return routes.build();
    }
}

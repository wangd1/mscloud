package com.wang.sc.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dwang
 * @create 2020-03-06 16:11
 */
@Configuration
public class FeignConfig {

    @Bean
    Logger.Level feignLogger(){
        return Logger.Level.FULL;
    }
}

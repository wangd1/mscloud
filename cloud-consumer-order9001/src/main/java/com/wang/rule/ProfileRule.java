package com.wang.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dwang
 * @create 2020-03-06 13:35
 */
@Configuration
public class ProfileRule {

    @Bean
    public IRule myRule(){
        return new RandomRule();
    }
}

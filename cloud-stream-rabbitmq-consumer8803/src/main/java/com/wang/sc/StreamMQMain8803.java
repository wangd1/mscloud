package com.wang.sc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

/**
 * @author dwang
 * @create 2020-03-08 12:44
 */
@SpringBootApplication
@EnableBinding
public class StreamMQMain8803 {

    public static void main(String[] args) {
        SpringApplication.run(StreamMQMain8803.class,args);
    }
}

package com.xyc.learn.sub.controller;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author ：xuyichao
 * @description：
 * @date ：2021/6/8 14:05
 */
@RestController
@Configuration
public class InvokerController {
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
    @GetMapping("/router")
    public String router(){
        RestTemplate restTemplate = getRestTemplate();
        String json = restTemplate.getForObject("http://first-service-provider/person/1", String.class);
        return json;
    }
}

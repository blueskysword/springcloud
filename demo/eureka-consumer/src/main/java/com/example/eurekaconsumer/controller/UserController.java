package com.example.eurekaconsumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * User: lr
 * Date: 2020/6/8
 * Description:
 */
@RestController
@RequestMapping("/consumer")
public class UserController {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/demo")
    public String consumerdemo() {
        return this.restTemplate.getForObject("http://localhost:9000/producer/demo",String.class);

    }

    @RequestMapping("/ribbon")
    public String consumerdemo2() {
        return this.restTemplate.getForObject("http://eureka-producer/producer/demo2",String.class);

    }

}

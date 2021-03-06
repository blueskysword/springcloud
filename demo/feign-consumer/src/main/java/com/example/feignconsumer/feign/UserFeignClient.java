package com.example.feignconsumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * User: lr
 * Date: 2020/6/16
 * Description: feign的调用接口封装
 */
@FeignClient(name = "eureka-producer")
public interface UserFeignClient {

    @GetMapping("/producer/demo3")
    String findById(@RequestParam(value = "id") Integer id);
}

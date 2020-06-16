package com.example.feignconsumer.controller;

import com.example.feignconsumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * User: lr
 * Date: 2020/6/16
 * Description:
 */
@RequestMapping("/feign")
@RestController
public class UserController {

    @Resource
    private UserFeignClient userFeignClient;

    @GetMapping("/user")
    public String findById() {
        return this.userFeignClient.findById();
    }
}

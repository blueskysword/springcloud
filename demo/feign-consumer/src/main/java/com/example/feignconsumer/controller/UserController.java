package com.example.feignconsumer.controller;

import com.example.feignconsumer.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * User: lr
 * Date: 2020/6/16
 * Description:
 */
@RequestMapping("/feign")
@RestController
public class UserController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/user")
    public String findById(@RequestParam(value = "id") Integer id) {
        return this.userFeignClient.findById(id);
    }
}

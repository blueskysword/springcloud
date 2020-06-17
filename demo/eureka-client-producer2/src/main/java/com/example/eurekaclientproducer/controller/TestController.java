package com.example.eurekaclientproducer.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

/**
 * User: lr
 * Date: 2020/6/8
 * Description:
 */
@RestController
@RequestMapping("/producer")
public class TestController {

    @Resource
    private EurekaClient eurekaClient;

    @RequestMapping(value = "/demo",method = RequestMethod.GET)
    public String test(){
        return "hello world!";
    }

    @RequestMapping(value = "/demo2",method = RequestMethod.GET)
    public String test2(){
        System.out.println("#########producer2############"+new Date());
        InstanceInfo info =  eurekaClient.getNextServerFromEureka("eureka-producer",false);
        return info.getHomePageUrl();
    }

    @RequestMapping(value = "/demo3",method = RequestMethod.GET)
    public String test3(Integer id){
        System.out.println("#########producer2############"+new Date());
        InstanceInfo info =  eurekaClient.getNextServerFromEureka("eureka-producer",false);
        return "producer2"+info.getHomePageUrl()+id;
    }
}

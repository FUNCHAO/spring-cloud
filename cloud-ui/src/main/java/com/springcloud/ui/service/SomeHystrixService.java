package com.springcloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 使用ribbon调用Some Service 并使用断路器
 * 使用Ribbon只需要注入RestTemplate即可
 */
@Service
public class SomeHystrixService {
    @Autowired
    RestTemplate restTemplate;
    @HystrixCommand(fallbackMethod = "fallbackSome")//指定失败备用方法
    public String getSome(){
        return restTemplate.getForObject("http://cloud-some/getsome",String.class);
    }
    public String fallbackSome(){
        return "some service error";
    }
}

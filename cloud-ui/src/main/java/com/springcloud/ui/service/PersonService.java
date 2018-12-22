package com.springcloud.ui.service;

import com.springcloud.ui.Entity.Person;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient("cloud-person")
public interface PersonService {
    @RequestMapping(value = "/save",method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,consumes =MediaType.APPLICATION_JSON_VALUE )
    @ResponseBody
    List<Person> save(@RequestBody String name);
}

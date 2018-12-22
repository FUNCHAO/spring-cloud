package com.springcloud.ui.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.ui.Entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 调用 Person Service 的断路器
 */
@Service
public class PersonHystrixService {
    @Autowired
    PersonService personService;

    @HystrixCommand(fallbackMethod = "fallbackSave")//指定方法调用失败后备用方法
    public List<Person> save(String name){
        return personService.save(name);
    }
    public List<Person> fallbackSave(){
        List<Person> list=new ArrayList<Person>();
        Person person=new Person();
        person.setName("Person Service error");
        list.add(person);
        return list;
    }
}

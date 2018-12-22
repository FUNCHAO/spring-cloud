package com.springcloud.person.PersonController;

import com.springcloud.person.Entity.Person;
import com.springcloud.person.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {
    @Autowired
    private PersonRepository personRepository;
    @PostMapping (value = "/save")
    public List<Person> savePerson(@RequestBody String personName){
        Person p=new Person();
        p.setName(personName);
        personRepository.save(p);
        List<Person> people = personRepository.findAll(new PageRequest(0, 10)).getContent();
        return people;
    }
}

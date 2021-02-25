package com.example.demo.springbean.service;

import com.example.demo.springbean.entity.Person;
import org.springframework.stereotype.Service;

//@Service
public class PersonService {

    public String getPersonName(){
        return new Person("Johnny","108").getName();
    }

    public String getPersonAge(){
        return new Person("Johnny","108").getAge();
    }
}

package com.example.demo.springbean;

import com.example.demo.DemoApplication;
import com.example.demo.springbean.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ImportResource;

@SpringBootTest(classes = DemoApplication.class)
public class SpringTest {

//    @Autowired
//    private PersonService personService;
    @Autowired
    private PersonService personService;


    @Test
    public void getPersonName(){
        String getName = personService.getPersonName();
        System.out.println("---getName:---"+getName);

    }
    @Test
    public void getPersonName2(){
        String getName = personService.getPersonName();
        System.out.println("---getName2:---"+getName);

    }
    @Test
    public void getPersonAge(){
        String getAge = personService.getPersonAge();
        System.out.println("---getAge:---"+getAge);
    }
}

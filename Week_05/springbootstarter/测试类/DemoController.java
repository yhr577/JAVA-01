package com.rongsoft.springbootdemo.controller;


import com.rongsoft.springdemo.configuration.entity.Klass;
import com.rongsoft.springdemo.configuration.entity.School;
import com.rongsoft.springdemo.configuration.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class DemoController {

    @Autowired
    public ApplicationContextManager applicationContextManager;

    @RequestMapping("/getStudent")
    public void getStudent(){
        ApplicationContext applicationContext = applicationContextManager.getApplicationContext();
        String[] beanNames = applicationContext.getBeanDefinitionNames();
        for (String beanName:beanNames) {
            System.out.println("beanName:"+beanName);
        }
        School school = applicationContext.getBean(School.class);
        school.ding();

        Klass klass = applicationContext.getBean(Klass.class);
        klass.dong();

        Student student = applicationContext.getBean(Student.class);
        student.print();

    }

}

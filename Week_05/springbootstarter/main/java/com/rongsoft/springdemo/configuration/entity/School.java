package com.rongsoft.springdemo.configuration.entity;


import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

@Data
public class School implements ISchool {

    // Resource 
    @Autowired(required = true) //primary
            Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding() {
        System.out.println("学校里Class1 所有同学: " + this.class1.getStudents().toString() + ". students and one is " + this.student100);

    }

}

package com.rongsoft.springdemo.configuration.entity;


import com.alibaba.fastjson.JSON;
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
        System.out.println("学校里Class1 所有同学: " + JSON.toJSONString(this.class1.getStudents()) + ". students and one is " + this.student100);

    }

}

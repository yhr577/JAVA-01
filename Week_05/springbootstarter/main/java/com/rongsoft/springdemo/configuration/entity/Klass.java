package com.rongsoft.springdemo.configuration.entity;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Klass {

    List<Student> students;

    public void dong() {
        System.out.println("班级1所有同学:"+JSON.toJSONString(this.getStudents()));
    }

}

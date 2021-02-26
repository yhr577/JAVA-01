package com.rongsoft.springdemo.configuration.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Klass {

    List<Student> students;

    public void dong() {
        System.out.println("班级1所有同学:"+this.getStudents().toString());
    }

}

package com.rongsoft.springdemo.configuration.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;


@Data
@NoArgsConstructor
@ToString
public class Student implements Serializable, BeanNameAware, ApplicationContextAware {


    private int id;
    private String name;

    private String beanName;
    private ApplicationContext applicationContext;
    
    public void init(){
        System.out.println("hello...........");
    }

    public Student(int id, String name, String beanName,ApplicationContext applicationContext) {
        this.id = id;
        this.name = name;
        this.beanName = beanName;
        this.applicationContext = applicationContext;
    }

    public Student create(int id,String name,String beanName){
        return new Student(id,name,beanName,applicationContext);
    }

    public void print() {
        System.out.println(this.beanName);
        System.out.println("某位同学student. context.getBeanDefinitionNames() ===>> "
                + String.join(",", applicationContext.getBeanDefinitionNames()));

    }

}

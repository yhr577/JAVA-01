package com.rongsoft.springdemo.configuration;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class KlassPojo2 implements ApplicationContextAware, Serializable, BeanNameAware {

    private int classId;
    private String className;
    private ApplicationContext applicationContext;

    @Override
    public void setBeanName(String name) {
        this.setBeanName(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }
}

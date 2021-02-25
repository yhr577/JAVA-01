package com.rongsoft.springdemo.configuration;

import com.rongsoft.springdemo.configuration.entity.Klass;
import com.rongsoft.springdemo.configuration.entity.School;
import com.rongsoft.springdemo.configuration.entity.Student;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Import;

import java.util.Arrays;

@Configuration
@ConditionalOnClass({ Student.class, KlassPojo.class, Klass.class })
public class EnableMyBeanConfiguration {

// 使用@Import({Student.class,Klass.class}) 与下面是一样的,不过Import方式需要按类型才能获取bean

    private ApplicationContext applicationContext;
    private Student student = new Student();

//    //常规bean
//    @Bean
//    @ConditionalOnMissingBean
//    public KlassPojo klassPojo(){
//        return new KlassPojo(301,"三年纪1班");
//    }
    //常规bean
    @Bean
    @ConditionalOnMissingBean
    public KlassPojo2 klassPojo2(){
        return new KlassPojo2(301,"三年纪1班",applicationContext);
    }

    @Bean
    @ConditionalOnMissingBean
    public Student student100(){
        Student student100 = student.create(10001,"10001","10001");
        applicationContext = student100.getApplicationContext();
        student.print();
        return student;
    }

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnBean(value = Student.class)
    public Klass klass1(){
        return new Klass(Arrays.asList(new Student[]{student.create(10001, "10001", "10001"), student.create(10002, "10002", "10002"),(Student) applicationContext.getBean("student100")}));
    }

    @Bean
    @ConditionalOnMissingBean
    public School student(){
        return new School();
    }
}

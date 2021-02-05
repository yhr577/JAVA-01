package com.rongsoft.week4.day3;


import java.util.concurrent.Callable;

public class CallableB implements Callable<Person> {

    Person person = new Person();
    public CallableB(Person person) {
        super();
        this.person = person;
    }


    @Override
    public Person call() throws Exception {
        person.setName("Hello");
        person.setSchool("Harward");
        return person;
    }
}

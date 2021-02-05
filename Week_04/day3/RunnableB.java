package com.rongsoft.week4.day3;


public class RunnableB implements Runnable{

//    public String str = "";
    Person person = new Person();
    public RunnableB(Person person) {
        super();
        this.person = person;
    }
    @Override
    public void run() {
        person.setName("Hello");
        person.setSchool("Harward");
    }

}

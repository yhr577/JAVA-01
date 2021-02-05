package com.rongsoft.week4.day3;


public class RunnableC implements Runnable{

    public String str = "";

    public RunnableC(String str) {
        super();
        this.str = str;
    }
    @Override
    public void run() {
        str = "ABC";
    }

}

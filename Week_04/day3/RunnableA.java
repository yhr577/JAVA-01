package com.rongsoft.week4.day3;


public class RunnableA implements Runnable{

    public static String str = "";

    public RunnableA(String str) {
        super();
        this.str = str;
    }
    @Override
    public void run() {
        str = "ABC";
    }

}

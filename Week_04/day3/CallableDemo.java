package com.rongsoft.week4.day3;

import java.util.concurrent.Callable;

/**
 * 利用Callable
 */
public class CallableDemo {
    public static void main(String[] args) {
        Callable callable = new Callable() {
            @Override
            public Object call() throws Exception {
                return "ABC";
            }
        };
        try {
            Object ab = callable.call();
            System.out.println("返回结果:"+ab.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

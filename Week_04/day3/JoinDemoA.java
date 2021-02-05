package com.rongsoft.week4.day3;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 利用join方法,让主线程等待子线程执行结束
 */
public class JoinDemoA {

    public static void main(String[] args) {
        Person person = new Person();
        Thread thread = new Thread(new RunnableB(person));
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.start();
        System.out.println("返回结果:"+ JSON.toJSONString(person));
    }
}

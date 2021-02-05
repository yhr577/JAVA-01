package com.rongsoft.week4.day3;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * 利用futuretask的get方法
 */
public class FutureDemoA {
    public static void main(String[] args) {
        CallableA callableA = new CallableA();
        FutureTask futureTask = new FutureTask(callableA);
        futureTask.run();
        Object str = "";
        try {
            str = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("返回结果:"+str);
    }
}

package com.rongsoft.week4.day3;

import java.util.concurrent.FutureTask;

/**
 * 利用FutureTask(Runnable runnable, V result)构造方法
 */
public class FutureDemoB {
    private static String str = "";

    public static void main(String[] args) {

        FutureTask<String> futureTask = new FutureTask(new Runnable() {
            @Override
            public void run() {
                str = "ABC";
            }
        }, str);
        futureTask.run();

        System.out.println("返回结果:"+ str);
    }
}

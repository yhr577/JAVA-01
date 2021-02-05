package com.rongsoft.week4.day3;

import java.util.concurrent.*;

import static sun.swing.SwingUtilities2.submit;

/**
 * 利用ExecutorService.submit(new CallableA());方法
 */
public class ExecuteServiceDemoB {

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future future = executorService.submit(new CallableA());
        executorService.shutdown();
        try {
            System.out.println("返回结果:"+ future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}

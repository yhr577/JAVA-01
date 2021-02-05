package com.rongsoft.week4.day3;

import com.alibaba.fastjson.JSON;

import java.util.concurrent.*;

/**
 * 此例失效,因为是 String类型,改为对象即可,参考
 * 利用ExecutorService.submit(new CallableA());方法
 */
public class ExecuteServiceDemoC {

    public static void main(String[] args) {
        //此处当Person 改为String时,获取不到值
        String str = "";
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new RunnableC(str),str);

        System.out.println("返回结果:"+ str);
        executorService.shutdown();
    }
}

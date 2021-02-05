package com.rongsoft.week4.day3;

import java.util.concurrent.Callable;

public class CallableA implements Callable<String> {

    @Override
    public String call() throws Exception {
        return "ABC";
    }
}

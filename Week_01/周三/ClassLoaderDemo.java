package com.rongsoft.week1;

/**
 * 作业1_2
 */
public class ClassLoaderDemo {
    public static void main(String[] args) {
        //C:\Users\ayg\Documents\Hello\Hello.xlass
        String classPath = "C:\\Users\\ayg\\Documents\\Hello";
        RongClassLoader rongClassLoader = new RongClassLoader();
        rongClassLoader.findClass(classPath);
        System.out.println("Hello==========");

    }
}

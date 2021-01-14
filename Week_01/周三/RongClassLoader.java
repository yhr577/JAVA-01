package com.rongsoft.week1;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 作业1_2
 */
public class RongClassLoader extends ClassLoader {

    public Class findClass(String classPath) {
        List<File> listFiles = null;
        try {
            listFiles = getAllFiles(classPath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (File xlassFile:listFiles) {
            byte[] b = getFileBytes(xlassFile);
            if (xlassFile.getName().endsWith(".xlass")){
                for (int i = 0; i < b.length; i++) {
                    int a = b[i];
                    b[i] = (byte) (255-a);
                }
            }else if (xlassFile.getName().endsWith(".java")){
                continue;
            }else if (xlassFile.getName().endsWith(".class")){
                continue;
            }
            String fileName = xlassFile.getName();
            Class clazz = defineClass(fileName.substring(0,fileName.lastIndexOf(".")), b, 0, b.length);
            if (clazz.getName().equals("Hello")){
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method:methods) {
                    if ("hello".equals(method.getName())){
                        method.setAccessible(true);
                        try {
                            method.invoke(clazz.newInstance(),null);
                            System.out.println("执行成功---------.");
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            return clazz;
        }
        return null;
    }

    public List<File> getAllFiles(String classPath) throws Exception {
        List<File> listFiles = new ArrayList<>();
        File file = new File(classPath);
        if (file.exists()){
            getFiles(file,listFiles);
            return listFiles;
        }else{
            throw new Exception("文件不存在,classPath:"+classPath);
        }

    }

    public byte[] getFileBytes(File classfile){
        String filename = classfile.getName();
        try{
            FileInputStream fileInputStream = new FileInputStream(classfile);
            ByteArrayOutputStream fileOutputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[2048];
            int ch = 0;
            while ((ch = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer,0,ch);
            }
            fileInputStream.close();
            fileOutputStream.flush();
            fileOutputStream.close();
            return fileOutputStream.toByteArray();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

    public List<File> getFiles(File file,List<File> listFiles){
       if (listFiles==null){
           listFiles = new ArrayList<>();
       }
        if (file.exists()&&file.isFile()){
            listFiles.add(file);
        }else if (file.exists()&&file.isDirectory()){
            File[] files = file.listFiles();
            for (File subfile:files) {
                getFiles(subfile,listFiles);
            }
        }
        return listFiles;
    }
}

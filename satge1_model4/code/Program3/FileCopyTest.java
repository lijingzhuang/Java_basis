package com.lagou.homework4.Program3;

import java.io.File;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FileCopyTest {

    public static void main(String[] args) {
        //创建线程池
        ExecutorService ex1 = Executors.newFixedThreadPool(10);

        File src = new File("d:/src");
        File dest = new File("d:/dest");
        File[] files = src.listFiles();
        for (File file:files){
           // System.out.println("这是文件" + file.getName() + "的线程");
            ex1.submit(new FileCopy(file,dest));
        }
        //关闭线程
        ex1.shutdown();
    }





}

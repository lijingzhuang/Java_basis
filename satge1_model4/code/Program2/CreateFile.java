package com.lagou.homework4.Program2;

import java.io.File;
import java.io.IOException;

public class CreateFile {

    //1.判断目录是否存在
    private static void ExistFile(String pathname){
        File file = new File(pathname);
        if(file.exists()){
            System.out.println("目录" + file.getPath() + "存在！");
        }else {
            System.out.println(file.mkdirs()? "目录" + file.getPath() + "创建成功！" : "文件目录创建失败！");
        }
    }

    //2.创建文件
    private static void createFile(String pathname) throws IOException {
        File file = new File(pathname);
        if(file.exists()){
            System.out.println("文件" + file.getName() + "存在！");
        }else {
            System.out.println(file.createNewFile()? file.getName() + "创建成功" : "文件创建失败");
        }
    }

    //递归创建子目录及文件
    public static void createFileRe(File directory,int count) throws IOException {
        createFile((directory.getPath() + "./file" + count + ".txt"));

        File[] files = directory.listFiles();
        if(files != null){
            for(File file:files) {
                createFileRe(file, count++);
            }
        }
    }

    public static void main(String[] args) {
        try {
            createFile("d:/homework/lagou/deletefile");
            createFile("d:/homework/lagou1/1");
            createFileRe(new File("d:/homework"),0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

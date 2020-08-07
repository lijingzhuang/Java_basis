package com.lagou.homework4.Program2;

import java.io.File;

public class DeleteFile {

    //指定文件目录
    private static final String DIR = "d:/homework/lagou/deletefile";

    //1.删除当前文件/目录方法
    public static void deleteFile(File file){
        if(file.exists()){
            if(file.isFile()){
                System.out.println(file.delete()? file.getName() + "文件删除成功" : file.getName() + "删除失败");
            }
            if(file.isDirectory()){
                System.out.println(file.delete()? file.getName() + "目录删除成功" : file.getName() + "删除失败");
            }
        }
        else {
            System.out.println("该文件/目录不存在！");
        }
    }

    //2.递归删除文件/目录的方法
    public static void deleteFileRe(File directory){
         File[] files = directory.listFiles();
         if(files != null){
             for(File file:files){
                 if(file.isFile()){
                     deleteFile(file);
                 }
                 if(file.isDirectory()){
                     deleteFileRe(file);
                     deleteFile(file);
                 }
             }
        }
    }

    public static void main(String[] args) {

        deleteFileRe(new File("d:/homework/lagou/deletefile"));
    }
}

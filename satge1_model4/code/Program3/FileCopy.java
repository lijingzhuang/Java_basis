package com.lagou.homework4.Program3;

import java.io.*;
import java.util.concurrent.Callable;

public class FileCopy implements Callable /*extends Thread*/{

    //定义要读取的源文件和复制文件
    private File src ;
    private  File dest;

    //构造函数

    public FileCopy(File src, File dest) {
        this.src = src;
        this.dest = dest;
    }



    public static void copyFile(File src,File dest){
        File newFile = new File(dest.getPath() + "/" + src.getName());

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        //首先判断是文件还是目录
        if(src.isDirectory()){
            //若不存在则创建
            if(newFile.exists()){
                System.out.println("目录" + newFile.getName() + "存在！");
            }else {
                System.out.println(newFile.mkdirs()? "目录" + newFile.getPath() + "创建成功" :
                        "目录" + newFile.getPath() + "创建失败" );
            }
        }else if(src.isFile()){
            try {

                bis = new BufferedInputStream(new FileInputStream(src));
                bos = new BufferedOutputStream(new FileOutputStream(newFile));

                byte[] arr = new byte[1024];
                int res = 0;
                while ((res = bis.read(arr)) != -1){
                    bos.write(arr,0,res);
                }
                System.out.println("复制文件" + src.getName() + "成功！");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    bos.close();
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //递归复制文件到目录
    public void copyFileRe(File src,File dest){
        if(src.exists()){
            copyFile(src,dest);
            if(src.isDirectory()){
                File[] files = src.listFiles();
                if(files != null){
                    for(File file:files){
                        copyFileRe(file,new File(src.getPath() + "/" + src.getName()));
                    }
                }
            }
        }else {
            System.out.println("当前需要复制的文件有误！！！");
        }
    }
    public File file;
    @Override
    public Object call() throws Exception {
        System.out.println("线程" + Thread.currentThread().getId() + "已启动，源文件为：" + this.file +
                "目录为：" + this.dest);
        return null;
    }
}

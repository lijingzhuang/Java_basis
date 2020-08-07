package com.lagou.homework4.Program5.Client;

import java.io.*;
import java.net.Socket;

public class ClientTool {


    //创建本地存储目录
    public static void createLocalStorage(String username) {
        File file = new File("./storage/client" + username);
        if(file.exists()){
            System.out.println("本地存储目录已存在：" + file.getPath());
        }else {
            System.out.println(file.mkdirs()? "本地存储目录创建成功：" + file.getPath() :
                    "本地目录创建失败！" + file.getPath());
        }
    }

    public static void sendFile(File file, Socket socket) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(socket.getOutputStream());

            //读取后写入
            byte[] arr = new byte[1024];
            int res = 0;
            while ((res = bis.read(arr)) != -1) {
                bos.write(arr, 0, res);
                bos.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //服务器接收文件
    public static void recieveFileFromServer(Socket socket, File file) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(socket.getInputStream());
            bos = new BufferedOutputStream(new FileOutputStream(file));
            //读取后写入
            byte[] arr = new byte[1024];
            int res = 0;
            while ((res = bis.read(arr)) > 0){
                bos.write(arr,0,res);
                bos.flush();
                if(res < 1024){
                    break;
                }
            }
            System.out.println("文件" + file.getName() + "已被保存至本地");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

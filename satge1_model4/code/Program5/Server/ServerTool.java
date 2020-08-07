package com.lagou.homework4.Program5.Server;

import java.io.*;
import java.net.Socket;

public class ServerTool {

    //创建存储目录
    public static void createLocalStroage() {
        File file = new File("./storage/client");
        if(file.exists()){
            System.out.println("本地存储目录已存在：" + file.getPath());
        }else {
            System.out.println(file.mkdirs()? "本地存储目录创建成功：" + file.getPath() :
                    "本地目录创建失败！" + file.getPath());
        }
    }

    public static void recieveFile(int socketNum, String fileName, String username) {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;

        try {
            bos = new BufferedOutputStream(new FileOutputStream("./storage/server" + fileName));
            bis = new BufferedInputStream(Server.sockets[socketNum].getInputStream());
            byte[] arr = new byte[1024];
            int res = 0;
            while ((res = bis.read(arr)) > 0){
                bos.write(arr,0,res);
                bos.flush();
                if(res < 1024){
                    break;
                }
            }
            System.out.println(username + "发送的文件" + fileName + "以保存至服务器本地");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void sendFiletoClient(int socketNum, File file, String name) {
        BufferedOutputStream bos = null;
        BufferedInputStream bis = null;

        try {
            bos = new BufferedOutputStream(new FileOutputStream("./storage/server" + name));
            bis = new BufferedInputStream(Server.sockets[socketNum].getInputStream());
            byte[] arr = new byte[1024];
            int res = 0;
            while ((res = bis.read(arr)) > 0){
                bos.write(arr,0,res);
                bos.flush();
                if(res < 1024){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void shareMsg(int id,String name,String msg) {
        PrintStream printStream = null;
        //组装信息并打印
        msg = name + " : " + msg;
        System.out.println(msg);

        for(int i = 0;i < Server.socketNum;i++){
            if(i == id){
                continue;
            }
            Socket s = Server.sockets[i];
            if(!s.isClosed()){
                try {
                    printStream = new PrintStream(s.getOutputStream());
                    printStream.println(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}

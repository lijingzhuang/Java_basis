package com.lagou.homework4.Program5.Client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;

public class Client1 {

    //定义用户名
    private static String username;
    public static void main(String[] args) {

        Socket socket = null;
        PrintStream printStream = null;

        try {
            //连接服务器并发送相关信息
            username = "机器人";
            socket = new Socket("127.0.0.1",13801);
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println(username);
            System.out.println("聊天室已连接！");

            ClientTool.createLocalStorage(username);   // 创建本地目录
            ClientReadRunable myRunnable = new ClientReadRunable(socket,username);
            Thread thread = new Thread((Runnable) myRunnable);
            thread.start();

            //循环获取信息并发送消息或者文件给服务器
            while (true){
                Thread.sleep(30000);
                printStream.println("大家好，我是聊天机器人！");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            if(null != printStream){
                printStream.close();
            }
            if(null != socket){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

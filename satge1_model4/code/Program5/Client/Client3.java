package com.lagou.homework4.Program5.Client;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class Client3 {
    //定义用户名
    private static String username;

    public static void main(String[] args) {
        Socket socket = null;
        PrintStream printStream = null;
        Scanner sc = null;

        try {
            //读取用户的名字
            sc = new Scanner(System.in);
            System.out.println("请输入你的姓名：");
            username = sc.nextLine().strip();

            //连接服务器并发送相关信息
            socket = new Socket("127.0.0.1",13801);
            printStream = new PrintStream(socket.getOutputStream());
            printStream.println(username);
            System.out.println("聊天室已连接！");

            ClientTool.createLocalStorage(username);   // 创建本地目录
            ClientReadRunable myRunnable = new ClientReadRunable(socket,username);
            Thread thread = new Thread((Runnable) myRunnable);       //读取线程
            thread.start();

            //循环获取用户聊天的输入，发送消息或者文件给服务器
            while (true){
                String userInput = sc.nextLine().strip();
                if("bye".equalsIgnoreCase(userInput)){
                    System.out.println("聊天结束！");
                    break;
                }else if("send".equalsIgnoreCase(userInput)){
                    System.out.println("请输入要发送的文件名：");
                    String fileName = sc.nextLine().strip();
                    //初始化文件
                    File file = new File("./storage/server" + "/" + fileName);
                    if(file.isDirectory()){
                        System.out.println("不支持发送文件夹目录！");
                        continue;
                    }
                    if(file.exists()){
                        printStream.println(userInput);
                        printStream.println(fileName);
                        //发送文件
                        ClientTool.sendFile(file,socket);
                    }else {
                        System.out.println("文件不存在！");
                    }
                }else if("download".equalsIgnoreCase(userInput)){
                    System.out.println("请输入文件名字：");
                    String fileName = sc.nextLine().strip();
                    printStream.println(userInput);
                    printStream.println(fileName);
                }else {
                    printStream.println(userInput);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.lagou.homework4.Program5.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class Server {
    //设置最大套接字数量5
    private static final int MAX_SOCKET = 10;
    public static Socket[] sockets = new Socket[MAX_SOCKET];
    public static int socketNum;

    static {      //初始化静态成员
        Arrays.fill(sockets,null);
        socketNum = 0;
    }

    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        BufferedReader bufferedReader = null;

        try {
            serverSocket = new ServerSocket(13801);
            ServerTool.createLocalStroage();
            System.out.println("等待客户端连接.......");

            while (socketNum < MAX_SOCKET) {
                sockets[MAX_SOCKET] = serverSocket.accept();
                //获取连接成功的用户名
                bufferedReader = new BufferedReader(new InputStreamReader(sockets[socketNum].getInputStream()));
                String name = bufferedReader.readLine();
                System.out.println("用户" + name + "已上线！");

                //启动线程读取客户端发送的消息
                ServerThreadRunnable myRunnable = new ServerThreadRunnable(socketNum, name);
                Thread thread = new Thread(myRunnable);
                thread.start();
                socketNum++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

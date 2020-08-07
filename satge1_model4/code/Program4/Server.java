package com.lagou.homework4.Program4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {



    private static void run(){
        //定义Object流以及服务器socket
        ServerSocket serverSocket = null;
        Socket socket = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        UserMessage userMessage = null;
        try {
            serverSocket = new ServerSocket(8888);
            System.out.println("正在等待端连接.....");

            while (true){
                socket = serverSocket.accept();
                System.out.println("客户端" + socket.getLocalAddress() + "连接成功");
                oos = new ObjectOutputStream(socket.getOutputStream());
                ois = new ObjectInputStream(socket.getInputStream());

                //读取客户端发送的消息
                try {
                    userMessage = (UserMessage)ois.readObject();
                    System.out.println("客户端发送的消息为：" + userMessage);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }

                //判断用户名及密码是否正确，并将判断结果发送至客户端
                if(userMessage != null && "check".equalsIgnoreCase(userMessage.getType())){
                    User user = userMessage.getUser();
                    if("admin".equalsIgnoreCase(user.getName()) && "123456".equals(user.getPasswd())){
                        oos.writeObject(new UserMessage("success",user));
                        System.out.println("发送 success 给客户端 ");
                    }else {
                        oos.writeObject(new UserMessage("failed",user));
                        System.out.println("发送 failed 给客户端");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(null != oos){
                    oos.close();
                }
                if(null != ois){
                    ois.close();
                }
                if(null != serverSocket){
                    serverSocket.close();
                }
                if(null != socket){
                    socket.close();
                }
                System.out.println("服务器断开连接！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        //运行
        run();
    }
}

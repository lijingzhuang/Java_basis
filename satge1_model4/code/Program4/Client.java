package com.lagou.homework4.Program4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
*   使用TCP编程模型实现将 UserMessage类型的对象由客户端发送给服务器
*       1.服务器接收到判断用户名和密码是否为：admin,123456;
*       2.客户端接收到服务器发来的消息判断用户登陆成功or 失败
* */
public class Client {


    //定义运行客户端的方法
    private static void run(){
        Scanner sc = null;
        Socket socket = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        UserMessage userMessage = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            System.out.println("已成功连接服务器！");

            //输入输出流
            //System.out.println("请输入相关信息：");
            sc = new Scanner(System.in);
            /*
            *   此处得出应先输出在输入，不然虽不报错但是无法输入相关验证
            * */
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());

            //获取用户输入的信息：用户名、密码
            User user = new User();
            System.out.println("请输入用户名：");
            user.setName(sc.next().strip());
            System.out.println("请输入密码：");
            user.setPasswd(sc.next().strip());

            //将用户登录消息发送给服务器
            oos.writeObject(new UserMessage("check",user));
            System.out.println("已成功发送消息！");

            try {
                userMessage = (UserMessage) ois.readObject();
                System.out.println("服务器收到的验证信息为：" + userMessage);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            if(userMessage != null){
                if("success".equalsIgnoreCase(userMessage.getType())){
                    System.out.println("用户登录成功！");
                }else if("failed".equalsIgnoreCase(userMessage.getType())){
                    System.out.println("用户登录失败！");
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
                if(null != socket){
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("已成功断开连接！");
        }
    }

    public static void main(String[] args) {
        //运行
        run();
    }
}

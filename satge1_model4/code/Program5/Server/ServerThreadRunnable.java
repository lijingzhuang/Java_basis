package com.lagou.homework4.Program5.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.SocketException;

public class ServerThreadRunnable implements Runnable{

    private int socketNum;
    private String name;

    public ServerThreadRunnable(int socketNum, String name) {
        this.socketNum = socketNum;
        this.name = name;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Server.sockets[socketNum].getInputStream()));
            while (true){
                //获取客户端信息
                String msg = bufferedReader.readLine();
                if (null ==msg){
                    break;
                }
                if("send".equalsIgnoreCase(msg)){
                    String fileName = bufferedReader.readLine();
                    ServerTool.recieveFile(socketNum,fileName,name);
                    //把文件名发给所有客户端用户
                    ServerTool.shareMsg(socketNum,name,"分享了文件" + fileName);
                }else if("download".equalsIgnoreCase(msg)){
                    String fileName = bufferedReader.readLine();
                    //从本地目录获取相应的文件发送给客户端
                    File file = new File("./storage/server" + fileName);
                    ServerTool.sendFiletoClient(socketNum,file,name);
                }else {
                    //与其他客户端共享该信息
                    //ServerTool.shareMsg(msg);
                }
            }
        } catch (SocketException e){
            System.out.println(name + "被异常中断，信息：" + e.getMessage());
            if(Server.sockets[socketNum].isClosed()){
                System.out.println(name + "socket中断！");
            }else{
                System.out.println(name + "socket未中断");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

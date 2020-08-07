package com.lagou.homework4.Program5.Client;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientReadRunable implements  Runnable{

    private Socket socket;
    private String username;

    public ClientReadRunable(Socket socket, String username) {
        this.socket = socket;
        this.username = username;
    }

    @Override
    public void run() {
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            while (true){
                String msg = bufferedReader.readLine();
                if(null == msg){
                    break;
                }
                if("file".equalsIgnoreCase(msg)){
                    String fileName = bufferedReader.readLine();
                    if("fail".equalsIgnoreCase(fileName)){
                        System.out.println("文件下载失败");
                    }else {
                        ClientTool.recieveFileFromServer(socket,new File("d:/send/file" + username + "/"
                                + fileName));
                }
            }else {
                System.out.println(msg);
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if(null != bufferedReader){
            try {
                bufferedReader.close();
            }catch (IOException e) {
                e.printStackTrace();
                }
            }
        }
    }
}

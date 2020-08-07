package com.lagou.homework4.Program1;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentManagementSystem {
    //定义List集合，将Student类指向list
    public static List<Student> stu = new ArrayList<>();
    public static Student std = new Student();
    public static boolean T = true;
    public static Scanner sc = new Scanner(System.in);
    private static File filepath = null;

    //1.实现学生信息增加功能
    private static void Add() {
        while (T) {
            System.out.println("请输入学号：");
            Student std  = new Student();
            try {
                std.setId(sc.nextInt());
            } catch (StudentIDException e) {
                e.printStackTrace();
            }
            System.out.println("请输入姓名：");
            std.setName(sc.nextLine());
            System.out.println("请输入年龄：");
            try {
                std.setAge(sc.nextInt());
            } catch (StudentAgeException e) {
                e.printStackTrace();
            }
            System.out.println("成功增加该生");
            stu.add(std);
            break;
        }
    }

    //2.实现删除功能
    private static void Del() {
        System.out.println("输入删除学生的姓名:");
        String name = sc.nextLine();
        for (int i = 0; i < stu.size(); i++) {
            if (name.equalsIgnoreCase(stu.get(i).getName())) {
                System.out.println("找到该生并正在删除：");
                stu.remove(i);
            } else {
                System.out.println("未找到需要删除的学生，请重新输入：");
            }
        }
    }

    //3.实现修改功能
    private static void Mod() {
        System.out.println("输入需要修改信息学生的姓名：");
        String name = sc.next();
        for (int i = 0; i < stu.size(); i++) {
            if (name.equalsIgnoreCase(stu.get(i).getName())) {
                System.out.println("输入修改后的名字：");
                String re_name = sc.nextLine();
                stu.get(i).setName(re_name);
                //修改年龄
                int re_age = sc.nextInt();
                try {
                    stu.get(i).setAge(re_age);
                } catch (StudentAgeException e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("未找到该生，请重新输入");
            }
        }
    }

    //4.实现查找功能
    private static void Fin() {
        for (Student c : stu) {
            System.out.println("学号：" + c.getId() + "姓名：" + c.getName() + "年龄" + c.getAge());
        }
    }

    //5.本地读取学生信息
    private static void Read(){
        File file = new File(String.valueOf(filepath));
        if(file.exists()){
            ObjectInputStream objectInputStream = null;
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(file));
                std = (Student) objectInputStream.readObject();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (null != objectInputStream){
                        objectInputStream.close();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //6.存储本地信息到本地文件
    private static void Save(){
        File file = new File(String.valueOf(filepath));
        ObjectOutputStream objectOutputStream = null;
        try {
            objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(stu);
            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (null != objectOutputStream){
                    objectOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    public static void main(String[] args) {

        //提示用户进入相关操作界面
        System.out.println("请根据需求选择您要进入得操作界面：");
        System.out.println("学生管理系统");
        System.out.println("【1】增加");
        System.out.println("【2】删除");
        System.out.println("【3】修改");
        System.out.println("【4】查找");
        System.out.println("【5】读取");
        System.out.println("【6】保存");
        System.out.println("【7】退出");


        //判断需要进入哪个操作界面
        while (T) {
            String select = sc.nextLine();
            switch (select) {
                case "1":
                    Add();
                    break;
                case "2":
                    Del();
                    break;
                case "3":
                    Mod();
                    break;
                case "4":
                    Fin();
                    break;
                case "5":
                    Read();
                    break;
                case "6":
                    Save();
                    break;
                case "7":
                    break;
            }
        }
    }
}

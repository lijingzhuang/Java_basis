package com.lagou.homework4.Program1;
/*
 *      1.自定义学号异常类和姓名异常类，并在成员变量不合理是产生异常对象并抛出
 *      2.当系统退出时，List集合将所有学生信息写入到文件中，但系统启动时读取文件
 *          中多有信息。
 *
 * */
//自定义学号异常类
public class StudentIDException extends Exception{
    //构造有参无参方法
    public StudentIDException(){}

    public StudentIDException(String id){
        super(id);
    }
}

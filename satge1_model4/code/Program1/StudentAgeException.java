package com.lagou.homework4.Program1;

//自定义年龄异常类
public class StudentAgeException extends Throwable {
    private int age;

    //构造有参无参方法
    public StudentAgeException(){}

    public StudentAgeException(String age){
        super(age);
    }

}

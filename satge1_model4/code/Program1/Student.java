package com.lagou.homework4.Program1;
/*
*   自定义学生类：姓名、年龄、学号
*   并继承两个自定义异常类
* */
public class Student {

    private int id;
    private int age;
    private String name;

    public Student() {
    }

    public Student(int id, int age, String name) throws StudentAgeException,StudentIDException{
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) throws StudentIDException{
        //继承自定义学号异常类
        if(id > 0){
            this.id = id;
        }else {
            throw new StudentIDException("该学号不在规定范围！！");
        }
    }

    public int getAge() {
        return age;
    }
    public void setAge(int age) throws StudentAgeException {
        //继承自定义年龄异常类
        if(age > 0 && age < 200){
            this.age = age;
        }else {
            throw new StudentAgeException("该生年龄不正常！！");
        }
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

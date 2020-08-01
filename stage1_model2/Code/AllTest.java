package com.lagou.homework2;

public class AllTest {

    public static void main(String[] args) {

        System.out.println("当前进入测试............");
        InternetPackage online = new InternetPackage();
        online.show(100,new SIMCard());
        System.out.println("---------------------------------------------------");
        CallPackageAbstract call = new CallPackage();

        call.show();

    }
}

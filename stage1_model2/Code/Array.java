package com.lagou.homework2;

import java.util.Arrays;
import java.util.Scanner;

public class Array {
    public static void main(String[] args) {

        System.out.println("输入二维数组： ");
        //分别输入行列元素
        Scanner sc = new Scanner(System.in);
        int [][]  arr = new int[16][16];
        for(int i = 0; i < arr.length  ;i++){
            for(int j = 0;j < arr[i].length ;j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //看下数组打印情况
        System.out.println("------------------------------");
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                System.out.print(arr[i][j] );
            }
            System.out.println();
        }
        //所有行列元素相加的累加结果
        int sum1 = 0;
        for(int i = 0;i < arr.length;i++){
            for(int j = 0;j < arr[i].length;j++){
                sum1 += arr[i][j]  ;
            }
        }
        System.out.println("所有元素的和为： " + sum1);
        System.out.println("======================================");
        //左上角到右下角所有元素的和
        int sum2 = 0;
        for(int i = 0;i < arr.length;i++){
            sum2 += arr[i][i];
        }
        System.out.println("正对角线元素和为：" + sum2);
        System.out.println("======================================");
        //右上角到左下角所有元素的和
        int sum3 = 0;
        for(int i = 0;i < arr.length;i++){
            sum3 += arr[i][arr[i].length - i - 1];
        }
        System.out.println("负对角线元素和为： " + sum3);
    }
}

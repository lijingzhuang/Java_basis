package com.lagou.homework2;

import java.util.Scanner;

public class CheckBoard {
    //声明变量
    char[][] arr = new char[17][17];

    //绘制棋盘成员方法
    public char[][] Board() {
        //先添加+号
        char[][] arr = new char[17][17];
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[i].length; j++) {
                arr[i][j] = '+';
            }
        }
        //第一行0~9,a~f
        for (int j = 1; j <= 10; j++) {
            arr[0][j] = (char) (86 + j);
        }
        //第一列0~9,a~f
        for (int i = 1; i <= 10; i++) {
            arr[i][0] = (char) (48 + i - 1);
        }
        for (int i = 11; i <= 10; i++) {
            arr[i][0] = (char) (86 + i);
        }
        return arr;
    }

    //打印棋盘
    public void Boardshow() {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "");
            }
            System.out.println();
        }
    }

    //开始下棋
    public boolean black = true;  //判断落什么颜色的棋
    Scanner input = new Scanner(System.in);

    public void PlayChess(Scanner input) {
        if (black) {
            System.out.println("黑色请落棋：");
        } else {
            System.out.println("白色请落棋：");
        }
        int x = input.nextInt();
        int y = input.nextInt();
        //判断能否落棋
        if (x > 0 && x < 16 && y > 0 && y < 16) {
            if (arr[x][y] != 0) {
                System.out.println("当前位置存在棋子，请重新落子..........");
                PlayChess(input);
            }
            if (black) {
                arr[x][y] = 1;   //1 表示落黑子
            } else {
                arr[x][y] = 2;   //2 表示落白子
            }
            //交替落棋
            black = !black;
        } else {
            System.out.println("此处不能落子，请重新落子........");
            PlayChess(input);
        }
    }

    //随着下棋进行，每次落子都需要判断输赢,五子连成即为赢者
    public boolean Judgment() {
        int cnt = 1;
        int x = input.nextInt();
        int y = input.nextInt();
        int curruntJudg = arr[x][y];
        //判断横竖方向是否为5
        for (int i = x - 1; i > 0; i--) {
            if (arr[i][y] == curruntJudg) {
                cnt++;
            } else {
                break;
            }
        }
        for (int i = x + 1; i < arr.length; i++) {
            if (arr[i][y] == curruntJudg) {
                cnt++;
            } else {
                break;
            }
        }
        System.out.println("当前横竖棋子数为：" + cnt);
        if (cnt >= 5) {
            return true;
        } else {
            cnt = 1;
        }
        System.out.println("------------------------------------------------------------");
        //判断斜方向上落子是否为5
        for (int i = y - 1; i > 0; i--) {
            if (arr[x][i] == curruntJudg) {
                cnt++;
            } else {
                break;
            }
        }
        for (int i = y + 1; i < arr.length; i--) {
            if (arr[x][i] == curruntJudg) {
                cnt++;
            } else {
                break;
            }
        }
        System.out.println("当前倾斜方向棋子数为：" + cnt);
        if (cnt >= 5) {
            return true;
        } else {
            cnt = 1;
        }
        return false;
    }


    //main方法
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CheckBoard chess = new CheckBoard();
        chess.Board();
        chess.Boardshow();
        while(true){
            System.out.println("请落子........");
            chess.Boardshow();
            if(chess.Judgment()){
                if(chess.black){
                    System.out.println("白子胜！！");
                }else {
                    System.out.println("黑子胜！！");
                }
                break;
            }
        }
    }
}

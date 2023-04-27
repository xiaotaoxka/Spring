package com.wztedu.spring.test;

import java.util.Scanner;

public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] arr = {2, 1, 4, 5, 3};
        int[] newArr;
        do {
            newArr = new int[arr.length - 1];

            for (int i = 0; i < newArr.length; i++) {
                newArr[i] = arr[i];
            }

            arr = newArr;

            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + " ");
            }

            System.out.println();

            System.out.println("是否还要删除 y / n");

            if (arr.length == 1) {
                System.out.println("数组中数据为1，不能继续删除");
                break;
            }

            char flag = scanner.next().charAt(0);
            if (flag == 'n') {
                break;
            }



        } while(true);
    }
}

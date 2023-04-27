package com.wztedu.spring.test;

public class Yest03 {
    public static void main(String[] args) {

        int[][] arr = {
                {1, 2, 3, 4, 5},
                {3, 4, 5, 4},
                {0, 9, 8},
                {1, 2, 3},
                {2, 3, 4}
        };

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }
}

package com.wztedu.spring.test;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student(100);
        Student student2 = new Student(200);
        //
        // swap(student1, student2);
        // System.out.println(student1.score);
        // System.out.println(student2.score);

        // int b;
        // int[] a = new int[3];
        // for (int i = 0; i < a.length; i++) {
        //     System.out.println(a[i]);
        // }

        Scanner myScanner = new Scanner(System.in);
        // 初始化数组
        int[] arr = {1, 2, 3};
        int[] arrNew;
        do {
            arrNew = new int[arr.length + 1];
            // 遍历 arr 数组，依次将arr的元素拷贝到 arrNew数组
            for (int i = 0; i < arr.length; i++) {
                arrNew[i] = arr[i];
            }
            System.out.println("请输入你要添加的元素");
            int addNum = myScanner.nextInt();
            // 把addNum赋给arrNew最后一个元素
            arrNew[arrNew.length - 1] = addNum;
            // 让 arr 指向 arrNew,
            arr = arrNew;
            // 输出arr 看看效果
            System.out.println("====arr扩容后元素情况====");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i] + "\t");
            }
            // 问用户是否继续
            System.out.println("是否继续添加 y/n");
            char key = myScanner.next().charAt(0);
            if (key == 'n') { // 如果输入n ,就结束
                break;
            }
        } while (true);

        System.out.println("你退出了添加...");
    }

    public static void swap(Student a, Student b) {
        Student t = new Student();
        t.score = a.score;
        // System.out.println(t.score);
        a.score = b.score;
        b.score = t.score;
    }
}

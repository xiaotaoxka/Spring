package com.wztedu.spring.test;

public class Test {
    public static void main(String[] args) {
        Student student1 = new Student(100);
        Student student2 = new Student(200);

        swap(student1, student2);
        System.out.println(student1.score);
        System.out.println(student2.score);
    }

    public static void swap(Student a, Student b) {
        Student t = new Student();
        t.score = a.score;
        // System.out.println(t.score);
        a.score = b.score;
        b.score = t.score;
    }
}

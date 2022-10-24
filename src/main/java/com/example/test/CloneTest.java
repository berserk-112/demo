package com.example.test;

public class CloneTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        //注意String浅拷贝时特殊性
        People p1 = new People("sun", 11);
        People p2 = (People)p1.clone();
        p2.setName("xxx"); //不会改变p1中的name, p1的name指向常量池中的"sun"， p2现在指向常量池的"xxx"
        p2.addSet(5);
        System.out.println(p1 == p2);
        System.out.println(p1.toString());
        System.out.println(p2.toString());
    }
}

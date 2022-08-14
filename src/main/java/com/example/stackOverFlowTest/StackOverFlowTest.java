package com.example.stackOverFlowTest;

public class StackOverFlowTest {
    public static void main(String[] args){
      //
        try {
            foo("hello world!");
        } catch (StackOverflowError e) {
            System.out.println("error");
        }
    }

    public static void foo(String str) {
//        System.out.println(str);
        try {
            foo(str);
        } catch (StackOverflowError e) {
            System.out.println("stackOverError");
        }
    }
}

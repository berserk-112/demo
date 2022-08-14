package com.example.outOfMemoryTest;

public class OOMTest {
    public static void main(String[] args){
      //
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < 2000000000; i++) {
            sb.append("hello world");
        }
        System.out.println(sb.toString());
    }
}

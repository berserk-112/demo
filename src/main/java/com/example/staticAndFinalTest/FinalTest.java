package com.example.staticAndFinalTest;

import edu.emory.mathcs.backport.java.util.Arrays;

import java.util.ArrayList;
import java.util.List;

public class FinalTest {
    public static void main(String[] args) {
        //不能修改str
        final String str = "123";

//        str = "111";
        //可以修改list内部的值，但是不能让list指向另一个引用
        final List<Integer> list = new ArrayList<>(Arrays.asList(new Integer[]{1, 2, 3}));

        for (Integer i : list) {
            System.out.print(i + ",");
        }
        System.out.println();
        list.set(0, 5);
        for (Integer i : list) {
            System.out.print(i + ",");
        }
        System.out.println();
    }
}

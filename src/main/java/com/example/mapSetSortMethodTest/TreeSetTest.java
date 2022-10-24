package com.example.mapSetSortMethodTest;

import sun.net.util.IPAddressUtil;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args){
        TreeSet<Integer> set = new TreeSet<>();
        set.add(10);
        set.add(20);
        set.add(5);
        set.add(100);
        System.out.println(set);
        System.out.println(set.ceiling(15)); //第一个大于15的元素
        System.out.println(set.higher(15));//同上
        System.out.println(set.lower(25)); //第一个小于25的元素
        byte[] ips = IPAddressUtil.textToNumericFormatV4("192.168.1.1"); //无符号
        for (byte ip : ips) {
            System.out.print(ip + ".");
        }
        System.out.println();
    }
}

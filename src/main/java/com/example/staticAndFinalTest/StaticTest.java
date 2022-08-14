package com.example.staticAndFinalTest;

import java.util.HashMap;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class StaticTest {
    public static void main(String[] args) {
        HashMap<Integer, Integer> map = new HashMap<>();
/*
        FutureTask futureTask = new FutureTask<>(() -> {
            System.out.println(11);
            return null;
        });
        StaticClass staticClass1 = new StaticClass(10);
        System.out.println(StaticClass.staticInt);
        StaticClass staticClass2 = new StaticClass(20);
        System.out.println(StaticClass.staticInt);
*/
    }

    static class StaticClass {
        static int staticInt;

        public StaticClass(int a){
            staticInt = a;
        }
    }
}

package com.example.AQSTest.threadPoolTest;

import java.util.Collections;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.LockSupport;

public class ThreadPoolTest {
    public static void main(String[] args) {
        System.out.println(~1);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10, 20, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

        int i = 1;
        while (i < 100) {
            threadPoolExecutor.execute(new MyTask(i));
            i++;
        }
    }
}

class MyTask extends Thread {
    int i;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "----" + i);
        while (true);
    }
}

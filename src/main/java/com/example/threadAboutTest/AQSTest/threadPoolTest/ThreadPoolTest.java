package com.example.threadAboutTest.AQSTest.threadPoolTest;

import java.util.concurrent.*;

public class ThreadPoolTest {
    public static void main(String[] args) {
        System.out.println(~1);
        ConcurrentMap<Integer, Integer> map = new ConcurrentHashMap<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                10, 10, 20, TimeUnit.SECONDS, new ArrayBlockingQueue<>(10));

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

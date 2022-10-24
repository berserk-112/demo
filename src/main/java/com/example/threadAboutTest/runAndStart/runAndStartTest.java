package com.example.threadAboutTest.runAndStart;

public class runAndStartTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                System.out.println("thread name is " + Thread.currentThread().getName());
                Thread.currentThread().join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        System.out.println("run()"); //不会创建一个新的线程
        thread.run();
        thread.run();
        System.out.println("start()"); //会创建一个新的线程
        thread.start();
        thread.isInterrupted();
        //不能start()两次 会抛出异常IllegalThreadException
//        thread.start();
    }
}

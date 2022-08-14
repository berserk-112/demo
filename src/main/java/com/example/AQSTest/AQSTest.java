package com.example.AQSTest;


import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.sleep;

public class AQSTest{
    public AQSTest() {
        new Thread(() -> {
            System.out.println(this.hashCode());
        }).start();
    }
    public static void main(String[] args) throws InterruptedException, UnknownHostException {
        ReentrantLock reentrantLock = new ReentrantLock();

        AQSTest aqsTest = new AQSTest();
        int num = 10;
        Thread thread1 = new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("thread1 is using lock");
                LockSupport.park(Thread.currentThread());
            }
            finally {
                reentrantLock.unlock();
            }
        });

        Thread thread2 = new Thread(() -> {
            reentrantLock.lock();
            try {
                System.out.println("thread2 is using lock");
                LockSupport.park(Thread.currentThread());
            } finally {
                reentrantLock.unlock();
            }
        });

        thread1.join();
        thread1.start();
        sleep(100);
        thread2.start();
//        LockSupport.unpark(thread1);
        InetAddress a = InetAddress.getByName("rocket");
        System.out.println(a);
        LockSupport.unpark(thread2);
    }
}

package com.example.lockSupportParkTest;

import java.util.concurrent.locks.LockSupport;

public class LockSupportParkTest {
    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            LockSupport.park(Thread.currentThread());
            System.out.println(11);
        });

        thread.start();

        System.out.println("22");
//        LockSupport.unpark(thread);
    }
}

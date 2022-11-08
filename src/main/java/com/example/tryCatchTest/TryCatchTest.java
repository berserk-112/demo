package com.example.tryCatchTest;

import java.util.Arrays;
import java.util.List;

public class TryCatchTest {
    public static void main(String[] args) {
        System.out.println(testA());
    }

    public static int testA() {
        int a = 10;
        try {
            return a;
        } finally {
            a = 11;
            return a;
        }
    }
}

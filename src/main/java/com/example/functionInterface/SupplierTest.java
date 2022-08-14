package com.example.functionInterface;

import java.util.Arrays;
import java.util.function.Supplier;

/**
 * Supplier函数式接口提供一个无参有返回值的接口
 */
public class SupplierTest {

    public static void main(String[] args) {
        SupplierTest.printMaxValue(() -> {
            int[] arr = {11, 15, 23, 41, 00, 02, 30, 4, 100};
            Arrays.sort(arr);
            return arr[arr.length - 1];
        });
    }

    private static void printMaxValue(Supplier<Integer> supplier) {
        System.out.println("max = " + supplier.get());
    }
}

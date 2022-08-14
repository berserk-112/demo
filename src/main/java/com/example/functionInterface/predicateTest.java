package com.example.functionInterface;

import java.util.function.Predicate;

public class predicateTest {
    public static void main(String[] args) {
        predicateLength(msg -> {
            return msg.length() > 3;
        }, "helloWorld");
    }

    private static void predicateLength(Predicate<String> predicate, String msg) {
        Boolean result = predicate.test(msg);
        System.out.println(result);
    }
}

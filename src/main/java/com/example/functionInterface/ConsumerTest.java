package com.example.functionInterface;

import java.util.function.Consumer;

/**
 * consumer函数式接口提供一个有参无返回值的接口方法
 */
public class ConsumerTest {
    public static void main(String[] args) {
        CovertToLowerCase(
                msg -> {
                    System.out.println(msg + "cover to lowerCase " + msg.toLowerCase());
                });

        ConsumerAndThenTest(
                msg -> {
                    System.out.println(msg + "cover to lowerCase " + msg.toLowerCase());
                },
                msg -> {
                    System.out.println(msg + "cover to upperCase " + msg.toUpperCase());
                });
    }

    private static void CovertToLowerCase(Consumer<String> consumer) {
        consumer.accept("Hello World");
    }

    private static void ConsumerAndThenTest(Consumer<String> lowerCase, Consumer<String> uppercase) {
        String msg = "Hello World";
/*
        lowerCase.accept(msg);
        uppercase.accept(msg);
*/
        //等价于
        lowerCase.andThen(uppercase).accept(msg);
    }
}

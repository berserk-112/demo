package com.example.functionInterface;

import java.util.function.Function;

/**
 * 有参数有返回值的函数式接口
 */
public class FunctionTest {
    public static void main(String[] args) {
        //这个lambda对应了function.apply()方法,所以只有一个参数，需要有返回值
        StringToInteger(
                msg -> {
                    return Integer.parseInt(msg);
                });

        functionAndThenTest(msg -> {
            return Integer.parseInt(msg);
        }, number -> {
            return String.valueOf(number);
        });
    }

    private static void StringToInteger(Function<String, Integer> function) {
        Integer apply = function.apply("666");
        System.out.println("apply = " + apply);
    }

    private static void functionAndThenTest(Function<String, Integer> StringToInt,
                                            Function<Integer, String> IntToString) {
/*
        Integer a = StringToInt.apply("10") + StringToInt.apply("20");
        System.out.println("a = " + IntToString.apply(a));
*/
        //andThen不能andThen同一个对象
        String ans = StringToInt.andThen(IntToString).apply("10");
        System.out.println(ans);
    }
}

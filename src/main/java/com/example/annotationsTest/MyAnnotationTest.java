package com.example.annotationsTest;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class MyAnnotationTest {
    public static void main(String[] args) throws NoSuchMethodException {
        MyAnnotationTest myAnnotationTest = new MyAnnotationTest();
        Method m = myAnnotationTest.getClass().getMethod("saySomething", String.class);
        MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
        System.out.println("my annotation value is " + annotation.value());
    }

    @MyAnnotation(value = 10)
    public void saySomething(String str) {
        System.out.println(str);
    }
}

package com.example.classLoading;

public class NoClassDefFoundErrorExample {
    public ClassWithInitErrors getClassWithInitErrors() {
        ClassWithInitErrors test;
        try {
            test = new ClassWithInitErrors();
        } catch (Throwable t) {
            System.out.println(t);
        }
        test = new ClassWithInitErrors();
        return test;
    }

    public static void main(String[] args) {
        NoClassDefFoundErrorExample noClassDefFoundErrorExample = new NoClassDefFoundErrorExample();
        noClassDefFoundErrorExample.getClassWithInitErrors();
    }
}
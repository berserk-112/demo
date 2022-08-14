package com.example.classLoading;

class SuperClass {
    static {
        System.out.println("SuperClass Init");
    }

    public static int value = 10;
}

class ChildClass extends SuperClass{
    static {
        System.out.println("StaticClass Init");
    }
}

class ConstClass {
    static {
        System.out.println("ConstClass Init");
    }

    public final static String str1 = "HHHH";
    public final static String str2 = new String("HHHH");
}

public class NoInitialization {
    public static void main(String[] args) {
        /**
         * test1
         * new 类的话会初始化
         */
        SuperClass superClass = new SuperClass();

        /**
         * test2
         *对于静态字段只有直接定义了这个字段的类才能初始化
         */
        System.out.println(ChildClass.value);

        /**
         * test3
         * new 数组类时，该类不会初始化
         * 但使用这个数组中的类的静态属性时，会初始化
         */
        SuperClass[] superClasses = new SuperClass[10];
        System.out.println(superClasses[0].value);

        /**
         * 直接引用类中的常量不会导致该类的初始化，
         * 该常量会放入常量池中，并转换为当前类NoInitialization对该常量的引用
         */
        System.out.println(ConstClass.str1);
        /**
         * ConstClass.str2不是常量，对其的使用会导致ConstClass的初始化
         */
        System.out.println(ConstClass.str2);
    }
}

package com.example.classInitTest;

import com.example.test.People;

/**
 * 子类没有重写父类方法时，也可以通过子类来调用父类的方法，但
 * 如果父类的这个方法中又调用了子类中重写过的方法，则会优先调用子类重写的方法
 *
 * 子类的构造器默认会调用父类无参构造器, 子类第一行默认被添加了super()
 *
 * 总之，再调用子类的方法时，会优先在子类中查找该方法，若没有找到则去父类中查找该方法，
 * 在父类的方法中又调用了新的方法时，也要按照上述规则先去查找子类中的方法。
 */
class Father {
    private int x = 2;
    private int y = 0;

    private int test = 1;
    {
        System.out.println("father block");
    }

    static {
        System.out.println("father static block");
    }
    public Father() {
        System.out.println("i am father");
    }

    public Father(int a) {
        x = a;
        System.out.println("i am fat father");
    }

    public int getZ() {
        int z = x + y;
        return z;
    }
    public void show() {
        System.out.println("x=" + x);
        System.out.println("y=" + y);
        System.out.println("Z=" + getZ());
    }

    public void makePeople() {

    }
}

class Child extends Father {
    private People p;
    public int x = 8;
    public int y = 2;

    {
        System.out.println("child block");
    }

    static {
        System.out.println("child static block");
    }
    public Child() {
        System.out.println("i am child");
    }
    public Child(int a) {
//        this(); //this() 和 super() 不能同时调用，它们都要求在第一行被调用
        super(a);
    }

    @Override
    public int getZ() {
        int z = x / y;
        return z;
    }

    @Override
    public void makePeople() {
        p = new People("sun");
    }

    public People getPeople() {
        return p;
    }
}

class GrandSon extends Child {

}
public class ChildUseFatherMethod {
    public static void main(String[] args) {
//        Father father = new Father();
        Child child1 = new Child();
//        Child child = new Child(1);
//        System.out.println(child.getZ());
        GrandSon grandSon = new GrandSon();
        grandSon.makePeople();
        System.out.println(grandSon.getPeople().toString());
        System.gc();

//        father.show();
//        child.show();

        String str = "a,b,c,d,e";
        for (String s : str.split(",", 3)) {
            System.out.println(s);
        }
        System.out.println();
        for (String s : str.split(",", -1)) {
            System.out.println(s);
        }
    }
}

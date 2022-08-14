package com.example;

/**
 * 子类没有重写父类方法时，也可以通过子类来调用父类的方法，但
 * 如果父类的这个方法中又调用了子类中重写过的方法，则会优先调用子类重写的方法
 *
 * 总之，再调用子类的方法时，会优先在子类中查找该方法，若没有找到则去父类中查找该方法，
 * 在父类的方法中又调用了新的方法时，也要按照上述规则先去查找子类中的方法。
 */
class Father {
    private int x = 2;
    private int y = 0;

    public Father() {

    }

    public Father(int a) {
        x = a;
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
}

class Child extends Father {
    public int x = 8;
    public int y = 2;

    public Child(int a) {
        super(a);
    }

    @Override
    public int getZ() {
        int z = x / y;
        return z;
    }
}
public class ChildUseFatherMethod {
    public static void main(String[] args) {
        Father father = new Father();
        Child child = new Child(1);
        System.out.println(child.getZ());
        System.gc();

        father.show();
        child.show();
    }
}

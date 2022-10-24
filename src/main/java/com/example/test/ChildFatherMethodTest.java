package com.example.test;

class ChildFatherMethodTest {
    public static void main(String[] args) {
        System.out.println(new B().getValue());
    }

    static class A {
        protected int value;

        public A(int v) {
            setValue(v);
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getValue() {
            try {
                value++;
                return value;
            } finally {
                this.setValue(value);
                System.out.println(value);
            }
        }
    }

    static class B extends A {
        public B() {
            super(5);
            setValue(getValue() - 3);
        }

        public void setValue(int value) {
            super.setValue(2 * value);
        }
    }
}

/*
1.  new B()构造B类实例对象，进入B类的构造方法，B类构造方法的第一行代码用super(5)调用了父类带有参数的构造函数，父类的构造函数又调用了setValue()方法，但值得注意的是，子类中的方法覆盖父类的方法以后，由于向上转型，父类调用的方法实际上是子类的。那么这里的setValue(v);调用了B类的setValue()方法，而B类中setValue()方法又使用super关键字调用了父类的setValue()方法，将B实例的value值设置为2 x 5 = 10。那么到这里，B类的构造函数中第一行代码super(5)执行完毕，程序继续向下执行进入setValue(getValue()- 3);代码块。

2.  这里先执行getValue()方法，但因为B类中并没有重写该方法，这里需要调用父类的getValue()方法。进入A类getValue()方法，首先是value++，那么此时B的成员变量value值由 10变为11，程序继续向下执行，将11作为返回值，但此处要注意的一点是，在Try catch finally体系当中，在return之前始终会执行finally里面的代码，如果finally里面有return，则数据跟随finally改变。如果没有return，则原数据不跟随finally里改变的数据改变。那么进入finally代码块，由于此时正在初始化的是B类的一个对象（运行时多态），因此调用B类的setValue()方法。B类的setValue()方法中使用super关键字调用了父类的setValue()方法，将原有的value*2，即11 x 2 = 22，继续向下进行System.out.println(value);输出第一个数值22。随后，A类的getValue()方法将之前暂存的value=11返回。

第二个数值

1.  拿到getValue()方法返回值之后程序继续运行，此处代码变为setValue(11- 3);根据和之前相同的流程，B类成员变量value的值变为16。程序运行到此处，new B()执行完毕。

2.  回到main函数中，实例化的B类对象调用getValue()方法，B类中并没有重写该方法，需要调用父类的getValue()方法。getValue()方法第一行代码value++将B的成员变量value值变为17，此时执行到return代码，将value=17暂存，等待finally代码块运行完毕后返回。

3.  此处finally代码块执行流程和之前相同，这里不再赘述。那么执行完this.setValue(value);后，value值变为2 x 17 = 34。继续向下进行System.out.println(value);输出第二个数值34，return刚刚暂存的value=17。

第三个数值

回到main函数，将刚刚返回的值输出，就得到了第三个数值17。

综上所述，本题正确答案为B。
 */
package com.example.wildcardTest;

import com.example.synchronizedTest.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardTest {
    public static void main(String[] args) {
        int number = 100;
        System.out.println();
        System.out.println(number << 8 | '\'');
        //lists不能通过add()方法加入元素，但是可以将一个Apple类型的list赋值给lists
//        List<? extends Apple> lists = new ArrayList<>();
//        lists.add(new BadApple()); error
        List<? extends Apple> lists = Arrays.asList(new Apple(), new BadApple());
        Apple a = (Apple) lists.get(0);
        Apple b = (Apple) lists.get(1);
        System.out.println(b.getClass() == BadApple.class); //true
        System.out.println(b.getClass() == Apple.class); //false
        BadApple badApple0 = (BadApple) lists.get(1);
//        BadApple badApple1 = (BadApple) lists.get(0); //编译报错
        System.out.println(badApple0.toString());
//        System.out.println(badApple1.toString());
        //lists.add(new Fruit()); error
        //lists.add(new Apple()); error

        //Apple及其子类都可以add到list1中
        List<? super Apple> list1 = new ArrayList<>();
        list1.add(new Apple());
        list1.add(new BadApple()); //Apple子类可以向上转型成Apple
        //list1.add(new Fruit()); error

        Collections.copy(list1, lists);

        ArrayList<?> unknownList = new ArrayList<>();
        unknownList.add(null);
//         since the type is unknown, we can only add null or elements with an unspecified type (which effectively means only null can be added).
//        unknownList.add(a);
    }
}
class Fruit{
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class Apple extends Fruit{
    String name;

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}

class BadApple extends Apple{
    @Override
    public String toString() {
        return "bad apple";
    }
}
class Collections {
    public static <T> void copy(List<? super T> dest, List<? extends T> src)
    {
        for (int i=0; i<src.size(); i++)
            dest.set(i,src.get(i));
    }
}

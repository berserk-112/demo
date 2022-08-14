package com.example.reflectTest;

import com.example.test.People;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class ReflectTest {
    public static void main(String[] args) throws Exception{
        //正常调
        People p1 = new People("sun", 26);
        System.out.println(p1.getName());

        //反射调用
        Class clz = Class.forName("com.example.test.People");
        Method setName = clz.getMethod("setName", String.class);
        Constructor peopleConstructor = clz.getConstructor();
        People peopleObject = (People)peopleConstructor.newInstance();
        setName.invoke(peopleObject, "sun");
        Method getName = clz.getMethod("getName");
       System.out.println("people 's name " + peopleObject.getName());

        //有参构造器
        Constructor peopleConstructor1 = clz.getConstructor(String.class, int.class);
        Object peopleObject1 = peopleConstructor1.newInstance("sun", 26);
        System.out.println("people1 's name " + getName.invoke(peopleObject1));
    }
}


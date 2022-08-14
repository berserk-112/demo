package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Objects;

public class JDKDynamicProxy implements InvocationHandler {
    private Object target;

    JDKDynamicProxy(){
        super();
    }

    JDKDynamicProxy(Object target){
        super();
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result;

        if (Objects.equals("getOrderInfo", method.getName())) {
            System.out.println("before proxy");
            result = method.invoke(target, args);
            System.out.println("after proxy");
        } else {
            result = method.invoke(target, args);
        }
        return result;
    }
}

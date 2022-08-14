package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class TestProxy {
    public static void main(String[] args) {
        OrderService orderService = new OrderServiceImp();
        StaticProxy staticProxy = new StaticProxy(orderService);

        staticProxy.getOrderInfo();
        staticProxy.getOrderId();

        InvocationHandler handler = new JDKDynamicProxy(orderService);
        OrderService orderServiceProxy = (OrderService) Proxy.newProxyInstance(
                orderService.getClass().getClassLoader(),
                orderService.getClass().getInterfaces(),
                handler
        );
        orderServiceProxy.getOrderId();
        orderServiceProxy.getOrderInfo();

        CGLibDynamicProxy proxy = new CGLibDynamicProxy();
        OrderServiceImp orderServiceImp = (OrderServiceImp) proxy.getProxy(orderService);
        orderServiceImp.getOrderId();
        orderServiceImp.getOrderInfo();
    }
}

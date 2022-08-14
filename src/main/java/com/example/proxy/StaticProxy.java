package com.example.proxy;

public class StaticProxy {
    public OrderService orderService;

    StaticProxy(){};

    StaticProxy(OrderService orderService) {
        this.orderService = orderService;
    }

    public String getOrderInfo() {
        System.out.println("before proxy");
        String result = orderService.getOrderInfo();
        System.out.println("after proxy");
        return result;
    }

    public int getOrderId() {
        System.out.println("before proxy");
        int result = orderService.getOrderId();
        System.out.println("after proxy");
        return result;
    }
}

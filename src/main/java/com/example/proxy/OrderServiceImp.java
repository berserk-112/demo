package com.example.proxy;

public class OrderServiceImp implements OrderService{
    @Override
    public String getOrderInfo() {
        System.out.println("orderInfo");
        return "orderInfo";
    }

    @Override
    public int getOrderId() {
        System.out.println("123");
        return 123;
    }
}

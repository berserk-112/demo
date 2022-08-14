package com.example.test;

public class People {
    String name;
    int age;

    public People() {

    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public People(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

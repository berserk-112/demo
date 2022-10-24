package com.example.test;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class People implements Cloneable {
    private String name;
    private int age;

    private Set<Integer> set = new HashSet<>();
    public People() {

    }

    public void assertSanity() {
        if (age != age) {
            throw new AssertionError("false");
        }
    }
    public People(String name, int age) {
        this.name = name;
        System.out.println(this.name == name);
        this.age = age;
    }

    public People(String name) {this.name = name;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("name is " + name).append(" age is " + age).append("set is " + set.toString());
        return sb.toString();
    }

    public void setName1(String name) {
        this.name = new String(name);
    }
    public void addSet(int x) {
        set.add(x);
    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

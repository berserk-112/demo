package com.example.hashCode;

import java.util.HashSet;
import java.util.Set;

public class HashCodeTest {
    public static void main(String[] args) {
        People p1 = new People("sun", 18);
        People p2 = new People("sun", 18);
        System.out.println("p1.equals(p2) = " + p1.equals(p2));
        System.out.println("p1.hashCode" + p1.hashCode());
        System.out.println("p2.hashCode" + p2.hashCode());
        Set<People> set = new HashSet<>();
        set.add(p1);
        set.add(p2);
        for (People p : set) {
            System.out.println(p.hashCode() + "-----" + p.toString());
        }
    }
}

class People {
    String name;
    int age;

    public People() {

    }
    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (obj instanceof People) {
            if (((People) obj).age == this.age && this.name.equals(((People) obj).name)) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(this.name + "'s age is " + this.age);
        return sb.toString();
    }

/*
    @Override
    public int hashCode() {
        return this.name.hashCode() + this.age;
    }
*/
}
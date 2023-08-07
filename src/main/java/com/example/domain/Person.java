/*
 * Copyright (C) 2014 - 2034 万帮星星充电科技有限公司 <starcharge@wanbangauto.com>
 *
 * ====================================================================
 * 代码版权归【万帮星星充电科技有限公司】所有，盗版必究
 * 【万帮星星充电科技有限公司】保留最终解释权
 * ====================================================================
 */

package com.example.domain;

/**
 * @author SC9621
 * Date: 2023/8/7 9:45
 **/
public class Person {
    private String name;
    private int age;

    public Person(){};

    public Person(String name) {
        this(name, 0);
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }


}

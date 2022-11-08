package com.example.test;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        char myChar = 'g';
        String myStr = Character.toString(myChar);
        System.out.println("String is: "+myStr);
        myStr = String.valueOf(myChar);
        System.out.println("String is: "+myStr);
    }
}

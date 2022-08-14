package com.example.classLoading;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) {
                try {
                    Stack<Integer> st = new Stack<>();
                    Set<Integer> set = new HashSet<>();
                    String fileName = name.substring(name.lastIndexOf(".") + 1) + ".class";
                    fileName.indexOf('c');
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[is.available()];
                    is.read(bytes);
                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } catch (ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        };

    }
}

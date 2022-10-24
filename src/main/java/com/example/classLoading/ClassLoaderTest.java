package com.example.classLoading;

import co.elastic.clients.elasticsearch.watcher.Logging;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException {
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

        Class<?> c1 = myLoader.loadClass("com.example.DemoApplication");
        Class<? extends ClassLoader> aClass = myLoader.getClass();
        System.out.println(aClass);
        System.out.println(c1);
        System.out.println();
        printClassLoaders();
    }

    public static void printClassLoaders() throws ClassNotFoundException {

        System.out.println("Classloader of this class:"
                + ClassLoaderTest.class.getClassLoader());

        System.out.println("Classloader of Logging:"
                + Logging.class.getClassLoader());

        System.out.println("Classloader of ArrayList:"
                + ArrayList.class.getClassLoader());
    }
}

package com.example.inputStreamTest;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class TestBufferedInputStream {
    public static void main(String[] args) throws IOException {
        ClassLoader cl = TestBufferedInputStream.class.getClassLoader();
        InputStream in = cl.getResourceAsStream("mybatis-config.xml");
        BufferedInputStream bufIn = new BufferedInputStream(in);
        int read = bufIn.read();
        System.out.println(read);
    }
}
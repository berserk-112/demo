package com.example.transferFile;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
            ServerDemo serverDemo = new ServerDemo();
            Socket socket = new Socket("localhost",8585);
            OutputStream out = socket.getOutputStream();
            String str = "hello world";
            out.write(str.getBytes());
            out.flush();
            out.close();
            serverDemo.saveFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}

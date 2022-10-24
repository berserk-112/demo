package com.example.transferFile;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerDemo {
    private ServerSocket serverSocket;

    public ServerDemo() throws IOException {
        serverSocket = new ServerSocket(8585);
    }

    public void saveFile() throws IOException {
        byte[] buf = new byte[8096];
        char[] charBuf = new char[8096];
        String fileName = "/home/sun/tmp/1.txt";
        while (true) {
            Socket socket = serverSocket.accept();
            InputStream in = socket.getInputStream();
            OutputStream out = socket.getOutputStream();
            File file = new File(fileName);
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(fileName);
            int count = 0;
            while ((count = in.read(buf)) > 0) {
                for (int i = 0; i < count; i++) {
                    charBuf[i] = (char)buf[i];
                }
                fileWriter.write(charBuf, 0, count);
                fileWriter.close();
            }
        }
    }
}

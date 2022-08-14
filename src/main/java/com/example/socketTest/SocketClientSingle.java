package com.example.socketTest;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashSet;

public class SocketClientSingle {
    public static void main(String[] args) throws IOException {
        InetAddress ipAddr = InetAddress.getByName(null);
        System.out.println(ipAddr);
        HashSet<Integer> integers = new HashSet<>();

        Socket socket = new Socket(ipAddr, 8080);
        try {
            System.out.println("Socket:" + socket.toString() + integers.toString());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);

            for (int i = 0; i < 10; i++) {
                out.println("howdy" + i);
                String str = in.readLine();
                System.out.println(str);
            }

            out.println("END");
        } finally {
            System.out.println("closing....");
            socket.close();
        }
    }
}

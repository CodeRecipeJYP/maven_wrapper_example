package com.yangyinetwork;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        openSocket();
    }

    private static void openSocket() {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);

            Socket accepted = serverSocket.accept();
            acceptInputStream(accepted.getInputStream());
            accepted.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void acceptInputStream(InputStream inputStream) {
//        while (true) {
        try {
            byte[] buff = new byte[100];

            int read = inputStream.read(buff);
            System.out.printf("read: %d %n", read);
            System.out.println(new String(buff));
        } catch (IOException e) {
            e.printStackTrace();
        }
//        }
    }
}

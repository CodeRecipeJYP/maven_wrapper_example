package com.yangyinetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;


public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
        openSocket();
    }

    private static void openSocket() {
        final Executor executor = Executors.newFixedThreadPool(10);
        try {
            final ServerSocket serverSocket = new ServerSocket(8080);

            while (true) {
                Socket accepted = serverSocket.accept();
                executor.execute(RequestHandlingRunnableFactory.createWith(accepted));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

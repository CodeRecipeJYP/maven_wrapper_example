package com.yangyinetwork;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class SocketManager {
    private final int mPort;
    private final Executor mExecutor = Executors.newFixedThreadPool(10);

    public SocketManager(int port) {
        mPort = port;
    }

    public void open() {
        try {
            final ServerSocket serverSocket = new ServerSocket(mPort);

            while (true) {
                Socket accepted = serverSocket.accept();
                mExecutor.execute(RequestHandlingRunnableFactory.createWith(accepted));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

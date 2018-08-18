package com.yangyinetwork;

import java.io.IOException;
import java.net.Socket;

public class RequestHandler {
    private static RequestHandler sInstance = null;

    private RequestHandler() {
    }

    public static RequestHandler getInstance() {
        if (sInstance == null) {
            synchronized (RequestHandler.class) {
                if (sInstance == null) {
                    sInstance = new RequestHandler();
                }
            }
        }

        return sInstance;
    }

    public void handleRequest(Socket socket) {
        Printer.println("handleRequest");
        connectWithPrinter(socket);
        Printer.println("handledRequest");
    }

    private void connectWithPrinter(Socket socket) {
        try {
            Printer.print(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.yangyinetwork;

import java.net.Socket;

public class RequestHandlingRunnableFactory {
    public static Runnable createWith(final Socket accepted) {
        return new Runnable() {
            @Override
            public void run() {
                RequestHandler handler = RequestHandler.getInstance();
                handler.handleRequest(accepted);
            }
        };
    }
}

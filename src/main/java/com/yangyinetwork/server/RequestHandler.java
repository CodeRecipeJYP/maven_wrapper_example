package com.yangyinetwork.server;

import com.yangyinetwork.server.io.Printer;
import com.yangyinetwork.server.parser.Parser;
import com.yangyinetwork.server.responser.EchoResponser;
import com.yangyinetwork.server.responser.OkResponser;
import com.yangyinetwork.server.responser.Responser;
import com.yangyinetwork.server.sender.Sender;

import java.io.IOException;
import java.net.Socket;

public class RequestHandler {
    private static RequestHandler sInstance = null;
    private final Responser mResponser;

    private RequestHandler() {
//        mResponser = new EchoResponser();
        mResponser = new OkResponser();
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
        Printer.println("Started handleRequest");

        // 1. get input
        // 2. input to output
        // 3. print output
        // 4. close

        try {
            String parsed = Parser.parseFrom(socket.getInputStream());
            Printer.printf("parsed: %s\n", parsed);
            String response = mResponser.onReceive(parsed);
            Printer.printf("response: %s\n", response);
            Sender.send(response, socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Printer.println("Finished handleRequest");
    }
}

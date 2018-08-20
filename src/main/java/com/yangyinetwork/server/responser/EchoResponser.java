package com.yangyinetwork.server.responser;

import com.yangyinetwork.server.io.PrintUtils;

import java.io.InputStream;
import java.io.OutputStream;

public class EchoResponser implements Responser {
    @Override
    public void onReceive(InputStream inputStream, OutputStream outputStream) {
        PrintUtils.print(inputStream, outputStream);
    }

    @Override
    public String onReceive(String request) {
        return request;
    }
}

package com.yangyinetwork.server.responser;

import com.yangyinetwork.server.io.PrintUtils;
import com.yangyinetwork.server.io.Printer;

import java.io.InputStream;
import java.io.OutputStream;

public class OkResponser implements Responser {
    @Override
    public void onReceive(InputStream inputStream, OutputStream outputStream) {
        PrintUtils.print(outputStream, getResponse());
    }

    @Override
    public String onReceive(String request) {
        return getResponse();
    }

    private String getResponse() {
        StringBuilder sb = new StringBuilder();
        sb.append("HTTP/1.1 200 OK");
        sb.append("\r\n");
        sb.append("Date: Mon, 27 Jul 2009 12:28:53 GMT");
        sb.append("\r\n");
        sb.append("Content-Length: 0");
        sb.append("\r\n");
        sb.append("Connection: Closed");
        sb.append("\r\n");
        sb.append("\r\n");

        return sb.toString();
    }
}

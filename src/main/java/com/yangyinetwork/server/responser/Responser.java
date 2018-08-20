package com.yangyinetwork.server.responser;

import java.io.InputStream;
import java.io.OutputStream;

public interface Responser {
    void onReceive(InputStream inputStream, OutputStream outputStream);
    String onReceive(String request);
}

package com.yangyinetwork.server.io;

import java.io.*;

public class PrintUtils {
    public static void print(InputStream inputStream, OutputStream outputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        try {
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    String eof = "EOF\n";
                    outputStream.write(eof.getBytes("UTF-8"));
                    break;
                }

                outputStream.write(line.getBytes("UTF-8"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void print(OutputStream outputStream, String s) {
        try {
            outputStream.write(s.getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

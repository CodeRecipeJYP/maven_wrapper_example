package com.yangyinetwork;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Printer {
    private static PrintStream sOut = System.out;

    public static void print(InputStream inputStream) {
        Printer.println("print");
        byte[] buffer = new byte[1024 * 8];

        try {
            while (true) {
                int count = 0;

                if (inputStream.read(buffer) == -1) {
                    sOut.println("EOF");
                    break;
                }
                sOut.write(buffer, 0, count);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void println(String s) {
        sOut.println(s);
    }
}

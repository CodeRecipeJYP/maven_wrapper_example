package com.yangyinetwork.server.io;

import java.io.InputStream;
import java.io.PrintStream;

public class Printer {
    private static PrintStream sOut = System.out;

    public static void print(InputStream inputStream) {
        Printer.println("print");
        PrintUtils.print(inputStream, sOut);
    }

    public static void println(String s) {
        sOut.println(s);
    }

    public static void printf(String format, Object... args) {
        sOut.printf(format, args);
    }
}

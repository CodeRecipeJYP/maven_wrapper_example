package com.yangyinetwork.server.parser;

import com.yangyinetwork.server.io.Printer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Parser {
    public static String parseFrom(InputStream inputStream) {
        return stream2string(inputStream);
    }

//    private static String stream2string(InputStream inputStream) {
//        StringBuilder sb = new StringBuilder();
//
//        try {
//            while (true) {
//                int read = inputStream.read();
//                Printer.printf("[Read] = [%d]\n", read);
//                Printer.printf("[sb.length()] = [%d]\n", sb.length());
//                if (read == -1) {
//                    break;
//                }
//                sb.append((char) read);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return sb.toString();
//    }

    private static String stream2string(InputStream inputStream) {
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        StringBuilder result = new StringBuilder();

        try {
            while (true) {
                String line = bufferedReader.readLine();
//                Printer.printf("[ReadLine] = [%s]\n", line);
                if (line == null) {
                    break;
                }

                if (line.isEmpty()) {
                    break;
                }

                result.append(line);
                result.append('\n');
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}

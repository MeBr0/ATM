package com.mebr0.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.mebr0.util.Printer.out;

/**
 * Class for getting input information from System.in stream
 * Only static methods
 *
 * Must be closed in the end of program
 *
 * @author A.Yergali
 * @version 1.1
 */
public class Scanner {

    private static final BufferedReader input;

    private static final Logger LOG = Logger.getInstance();

    public static final int ERROR = -1;

    static {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public static String ask(String text) {
        out(text + ": ");
        return input();
    }

    public static int index(String text) {
        out(text + ": ");
        return index();
    }

    public static int index() {
        String input = input();

        try {
            return Integer.parseInt(input);
        }
        catch (Exception e) {
            return ERROR;
        }
    }

    public static String input() {
        String result = "";

        try {
            while ((result = input.readLine()) != null) {
                break;
            }
        }
        catch (IOException e) {
            LOG.error("IO exception while reading from buffer");
        }

        return result;
    }
}

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
 * @version 2.0
 */
public abstract class Scanner {

    private static final BufferedReader input;

    private static final Logger LOG = Logger.getInstance();

    public static final int ERROR = -1;
    private static final String PIN_REGEX = "[0-9]{4}";

    private Scanner() {
        throw new AssertionError("No " + getClass().getSimpleName() + " instances for you!");
    }

    static {
        input = new BufferedReader(new InputStreamReader(System.in));
    }

    public static String pin(String text) {
        out(text + ": ");

        String pin = input();

        return pin.matches(PIN_REGEX) ? pin : "";
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

    public static double number(String text) {
        out(text + ": ");
        return number();
    }

    public static double number() {
        String input = input();

        try {
            return Double.parseDouble(input);
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

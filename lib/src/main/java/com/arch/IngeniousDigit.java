package com.arch;

import java.util.Arrays;
import java.util.List;

public class IngeniousDigit {
    /**
     * The 3x3 String representation of this digit
     */
    private final String _digit;

    private static List<String> DIGIT_STRINGS = Arrays.asList(
        " _ \n" +
        "| |\n" +
        "|_|\n",

        "   \n" +
        "  |\n" +
        "  |\n",

        " _ \n" +
        " _|\n" +
        "|_ \n",

        " _ \n" +
        " _|\n" +
        " _|\n",

        "   \n" +
        "|_|\n" +
        "  |\n",

        " _ \n" +
        "|_ \n" +
        " _|\n",

        " _ \n" +
        "|_ \n" +
        "|_|\n",

        " _ \n" +
        "  |\n" +
        "  |\n",

        " _ \n" +
        "|_|\n" +
        "|_|\n",

        " _ \n" +
        "|_|\n" +
        " _|\n"
    );

    public IngeniousDigit(String digit){
        _digit = digit;
    }

    public IngeniousDigit(int digit){
        _digit = DIGIT_STRINGS.get(digit);
    }

    public int toInt(){
        return toInt(_digit);
    }

    public static int toInt(String digit){
        return DIGIT_STRINGS.indexOf(digit);
    }

    @Override
    public String toString() {
        int value = toInt();

        return value != -1
            ? Integer.toString(value)
            : "?";
    }
}

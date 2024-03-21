/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.arch;

import java.util.AbstractList;
import java.util.Arrays;

public class IngeniousDigitList extends AbstractList<IngeniousDigit> {
    /**
     * The 2d array of 3x3 characters that make up the Ingenious Number
     */
    private final char[][] _digitLines;

    /**
     * @param ingeniousDigitLine a String consisting of 3x3-sized ASCII art of
     * numbers, with a trailing newline
     */
    public IngeniousDigitList(String ingeniousDigitLine){
        String[] lines = ingeniousDigitLine.split("\n");

        if(lines.length != 3){
            throw new IllegalArgumentException(
                "Ingenious digits should be *3* lines of ASCII art, got: '" + ingeniousDigitLine + "'"
            );
        }

        _digitLines = Arrays.stream(lines).map(String::toCharArray).toArray(char[][]::new);
    }

    @Override
    public IngeniousDigit get(int index) {
        StringBuilder digit = new StringBuilder();
        int baseChar = index * 3;

        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                digit.append(_digitLines[y][baseChar + x]);
            }
            digit.append('\n');
        }

        return new IngeniousDigit(digit.toString());
    }

    @Override
    public int size() {
        return Arrays.stream(_digitLines).mapToInt(a -> a.length).max().getAsInt() / 3;
    }

    @Override
    public String toString() {
        StringBuilder number = new StringBuilder();
        stream().map(IngeniousDigit::toInt).forEach(number::append);

        return number.toString();
    }
}
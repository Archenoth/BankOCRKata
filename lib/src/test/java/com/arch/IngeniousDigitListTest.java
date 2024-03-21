package com.arch;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class IngeniousDigitListTest {
    private static final String ZEROS =
        " _  _  _  _  _  _  _  _  _ \n" +
        "| || || || || || || || || |\n" +
        "|_||_||_||_||_||_||_||_||_|\n";

    private static final String ONES =
        "                           \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n";

    private static final String TWOS =
        " _  _  _  _  _  _  _  _  _ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n";

    private static final String THREES =
        " _  _  _  _  _  _  _  _  _ \n" +
        " _| _| _| _| _| _| _| _| _|\n" +
        " _| _| _| _| _| _| _| _| _|\n";

    private static final String FOURS =
        "                           \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "  |  |  |  |  |  |  |  |  |\n";

    private static final String FIVES =
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        " _| _| _| _| _| _| _| _| _|\n";

    private static final String SIXES =
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_ |_ |_ |_ |_ |_ |_ |_ |_ \n" +
        "|_||_||_||_||_||_||_||_||_|\n";

    private static final String SEVENS =
        " _  _  _  _  _  _  _  _  _ \n" +
        "  |  |  |  |  |  |  |  |  |\n" +
        "  |  |  |  |  |  |  |  |  |\n";

    private static final String EIGHTS =
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        "|_||_||_||_||_||_||_||_||_|\n";

    private static final String NINES =
        " _  _  _  _  _  _  _  _  _ \n" +
        "|_||_||_||_||_||_||_||_||_|\n" +
        " _| _| _| _| _| _| _| _| _|\n";

    private static final String COUNT =
        "    _  _     _  _  _  _  _ \n" +
        "  | _| _||_||_ |_   ||_||_|\n" +
        "  ||_  _|  | _||_|  ||_| _|\n";

    @Test void useCase1() {
        assertEquals("000000000", new IngeniousDigitList(ZEROS).toString());
        assertEquals("111111111", new IngeniousDigitList(ONES).toString());
        assertEquals("222222222", new IngeniousDigitList(TWOS).toString());
        assertEquals("333333333", new IngeniousDigitList(THREES).toString());
        assertEquals("444444444", new IngeniousDigitList(FOURS).toString());
        assertEquals("555555555", new IngeniousDigitList(FIVES).toString());
        assertEquals("666666666", new IngeniousDigitList(SIXES).toString());
        assertEquals("777777777", new IngeniousDigitList(SEVENS).toString());
        assertEquals("888888888", new IngeniousDigitList(EIGHTS).toString());
        assertEquals("999999999", new IngeniousDigitList(NINES).toString());
        assertEquals("123456789", new IngeniousDigitList(COUNT).toString());
    }

    @Test void shouldBeImmutable(){
        IngeniousDigitList idl = new IngeniousDigitList(ZEROS);
        assertFalse(idl.add(new IngeniousDigit(0)));
    }

    @Test void checkSumShouldPass(){
        assertTrue(IngeniousDigitList.checksum(Arrays.asList(3, 4, 5, 8, 8, 2, 8, 6, 5)));
    }
}

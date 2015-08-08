package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/7/15
 * Time: 10:47 PM
 */
public class StringToInteger_Test {
    StringToInteger_8 obj = new StringToInteger_8();
    @Test
    public void test1() {
        String input = "2147483647";
        int expected = 2147483647;
        int actual = obj.myAtoi(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String input = "-2147483648";
        int expected = -2147483648;
        int actual = obj.myAtoi(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String input = "-2147483649";
        int expected = -2147483648;
        int actual = obj.myAtoi(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String input = "  010";
        int expected = 10;
        int actual = obj.myAtoi(input);
        assertEquals(expected, actual);
    }

}

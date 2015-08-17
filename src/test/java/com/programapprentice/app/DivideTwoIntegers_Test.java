package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 7:22 PM
 */
public class DivideTwoIntegers_Test {
    DivideTwoIntegers_29 obj = new DivideTwoIntegers_29();
    @Test
         public void test1() {
        int dividend = 1;
        int divisor = 1;
        int expected = 1;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int dividend = -1010369383;
        int divisor = -2147483648;
        int expected = 1;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int dividend = -1010369383;
        int divisor = -2147483648;
        int expected = 1;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int dividend = -2147483648;
        int divisor = -1;
        int expected = 2147483647;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int dividend = 103;
        int divisor = 5;
        int expected = 20;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int dividend = 1100540749;
        int divisor = -1090366779;
        int expected = -1;
        int actual = obj.divide(dividend, divisor);
        assertEquals(expected, actual);
    }
}
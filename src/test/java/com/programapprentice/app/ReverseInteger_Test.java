package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/4/15
 * Time: 10:09 PM
 */
public class ReverseInteger_Test {
    ReverseInteger_7 obj = new ReverseInteger_7();

    @Test
    public void test1() {
        int input = 321;
        int expected = 123;
        int actual = obj.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int input = -321;
        int expected = -123;
        int actual = obj.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int input = 0;
        int expected = 0;
        int actual = obj.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int input = Integer.MAX_VALUE;
        int expected = 0;
        int actual = obj.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int input = Integer.MIN_VALUE;
        int expected = 0;
        int actual = obj.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int input = 900000;
        int expected = 9;
        int actual = obj.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        int input = -2147483412;
        int expected = -2143847412;
        int actual = obj.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test8() {
        int input = -2147483648;
        int expected = 0;
        int actual = obj.reverse(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test9() {
        int input = 1534236469;
        int expected = 0;
        int actual = obj.reverse(input);
        assertEquals(expected, actual);
    }
}

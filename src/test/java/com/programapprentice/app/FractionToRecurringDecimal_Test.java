package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 9/29/15
 * Time: 10:32 PM
 */
public class FractionToRecurringDecimal_Test {
    FractionToRecurringDecimal_166 obj = new FractionToRecurringDecimal_166();
    @Test
    public void test1() {
        int numerator = 1;
        int denominator = 6;
        String expected = "0.1(6)";
        String actual = obj.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
         public void test2() {
        int numerator = 5;
        int denominator = 7;
        String expected = "0.(714285)";
        String actual = obj.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int numerator = 50;
        int denominator = -700;
        String expected = "-0.0(714285)";
        String actual = obj.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int numerator = Integer.MIN_VALUE;
        int denominator = 1;
        String expected = "-2147483648";
        String actual = obj.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int numerator = -2147483648;
        int denominator = -1;
        String expected = "2147483648";
        String actual = obj.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int numerator = 50;
        int denominator = Integer.MIN_VALUE;
        String expected = "-0.000000023283064365386962890625";
        String actual = obj.fractionToDecimal(numerator, denominator);
        assertEquals(expected, actual);
    }
}

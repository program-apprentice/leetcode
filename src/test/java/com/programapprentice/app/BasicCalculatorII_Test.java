package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/9/15
 * Time: 11:22 PM
 */
public class BasicCalculatorII_Test {
    BasicCalculatorII_227 obj = new BasicCalculatorII_227();
    @Test
    public void test1() {
        String input = "0*0";
        int expected = 0;
        int actual = obj.calculate(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String input = "1 + 1";
        int expected = 2;
        int actual = obj.calculate(input);
        assertEquals(expected, actual);
    }
}

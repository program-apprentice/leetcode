package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/8/15
 * Time: 10:02 PM
 */
public class BasicCalculator_Test {
    BasicCalculator_224 obj = new BasicCalculator_224();
    @Test
    public void test1() {
        String input = "(1)";
        int expected = 1;
        int actual = obj.calculate(input);
        assertEquals(expected, actual);
    }
}

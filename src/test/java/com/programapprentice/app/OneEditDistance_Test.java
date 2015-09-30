package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 9/29/15
 * Time: 7:58 PM
 */
public class OneEditDistance_Test {
    OneEditDistance_161 obj = new OneEditDistance_161();

    @Test
    public void test1() {
        String s = "";
        String t = "a";
        boolean expected = true;
        boolean actual = obj.isOneEditDistance(s, t);
        assertEquals(expected, actual);
    }


    @Test
    public void test2() {
        String s = "ba";
        String t = "a";
        boolean expected = true;
        boolean actual = obj.isOneEditDistance(s, t);
        assertEquals(expected, actual);
    }

}

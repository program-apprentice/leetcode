package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 10:22 PM
 */
public class CountAndSay_Test {
    CountAndSay_38 obj = new CountAndSay_38();
    @Test
    public void test1() {
        int n = 2;
        String expected = "11";
        String actual = obj.countAndSay(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 3;
        String expected = "21";
        String actual = obj.countAndSay(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 4;
        String expected = "1211";
        String actual = obj.countAndSay(n);
        assertEquals(expected, actual);
    }
}

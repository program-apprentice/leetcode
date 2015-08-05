package com.programapprentice.app;


import junit.framework.TestCase;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/4/15
 * Time: 9:35 PM
 */
public class ZigZagConversion_Test {
    ZigZagConvertion_6 obj = new ZigZagConvertion_6();

    @Test
    public void test1() {
        String s = "PAYPALISHIRING";
        String expected = "PAHNAPLSIIGYIR";
        String actual = obj.convert(s, 3);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String input = "AGMBFHLNCEIKDJ";
        int nRows = 2;
        String expected = "AMFLCIDGBHNEKJ";
        String actual = obj.convert(input, nRows);
        TestCase.assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String input = "0123456789";
        int nRows = 2;
        String expected = "0246813579";
        String actual = obj.convert(input, nRows);
        TestCase.assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String input = "ABC";
        int nRows = 2;
        String expected = "ACB";
        String actual = obj.convert(input, nRows);
        assertEquals(expected, actual);
    }
}

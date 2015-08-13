package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/12/15
 * Time: 10:58 PM
 */
public class ExcelSheetColumnTitle_Test {
    ExcelSheetColumnTitle_168 obj = new ExcelSheetColumnTitle_168();

    @Test
    public void test1() {
        int n = 27;
        String expected = "AA";
        String actual = obj.convertToTitle(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 26;
        String expected = "Z";
        String actual = obj.convertToTitle(n);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 52;
        String expected = "AZ";
        String actual = obj.convertToTitle(n);
        assertEquals(expected, actual);
    }

}

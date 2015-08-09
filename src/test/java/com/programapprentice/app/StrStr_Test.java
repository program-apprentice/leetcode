package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 5:25 PM
 */
public class StrStr_Test {
    StrStr_28 obj = new StrStr_28();

    @Test
    public void test1() {
        String haystack = "abcdeasdfadf";
        String needle = "df";
        int expected = 7;
        int actual = obj.strStr(haystack, needle);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String haystack = "a";
        String needle = "";
        int expected = 0;
        int actual = obj.strStr(haystack, needle);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String haystack = "mississippi";
        String needle = "issipi";
        int expected = -1;
        int actual = obj.strStr(haystack, needle);
        assertEquals(expected, actual);
    }
}


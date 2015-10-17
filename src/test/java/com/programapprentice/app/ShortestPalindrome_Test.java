package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/15/15
 * Time: 8:08 PM
 */
public class ShortestPalindrome_Test {
    ShortestPalindrome_214 obj = new ShortestPalindrome_214();
    @Test
    public void test1() {
        String s = "abcd";
        String expected = "dcbabcd";
        String actual = obj.shortestPalindrome(s);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String s = "aacecaaa";
        String expected = "aaacecaaa";
        String actual = obj.shortestPalindrome(s);
        assertEquals(expected, actual);
    }
}

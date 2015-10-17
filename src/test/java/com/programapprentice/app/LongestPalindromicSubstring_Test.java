package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/15/15
 * Time: 10:14 PM
 */
public class LongestPalindromicSubstring_Test {
    LongestPalindromicSubstring_5 obj = new LongestPalindromicSubstring_5();
    @Test
    public void test1() {
        String s = "bb";
        String expected = "bb";
        String actual = obj.longestPalindromeManacher(s);
        assertEquals(expected, actual);
    }
}

package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 9/28/15
 * Time: 10:23 PM
 */
public class ReverseWordsInAString_Test {
    ReverseWordsInAString_151 obj = new ReverseWordsInAString_151();

    @Test
    public void test1() {
        String input = "the sky is blue ";
        String expected = "blue is sky the";
        String actual = obj.reverseWords(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String input = "the   sky is blue ";
        String expected = "blue is sky the";
        String actual = obj.reverseWords(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String input = "the    sky";
        String expected = "the sky";
        String actual = obj.removeSpace(input);
        assertEquals(expected, actual);
    }
}

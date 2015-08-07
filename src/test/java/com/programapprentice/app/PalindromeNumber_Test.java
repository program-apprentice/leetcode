package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/6/15
 * Time: 10:10 PM
 */
public class PalindromeNumber_Test {
    PalindromeNumber_9 obj = new PalindromeNumber_9();

    @Test
    public void test1() {
        int input = 32123;
        boolean expected = true;
        boolean actual = obj.isPalindrome(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int input = 321123;
        boolean expected = true;
        boolean actual = obj.isPalindrome(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int input = 0;
        boolean expected = true;
        boolean actual = obj.isPalindrome(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int input = 10;
        boolean expected = false;
        boolean actual = obj.isPalindrome(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int input = 1;
        boolean expected = true;
        boolean actual = obj.isPalindrome(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int input = 131000;
        boolean expected = false;
        boolean actual = obj.isPalindrome(input);
        assertEquals(expected, actual);
    }
}

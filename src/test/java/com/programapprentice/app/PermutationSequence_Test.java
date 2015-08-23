package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/22/15
 * Time: 11:06 PM
 */
public class PermutationSequence_Test {
    PermutationSequence_60 obj = new PermutationSequence_60();

    @Test
    public void test1() {
        int n = 2;
        int k = 1;
        String expected = "12";
        String actual = obj.getPermutation(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int n = 4;
        int k = 3;
        String expected = "1324";
        String actual = obj.getPermutation(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int n = 3;
        int k = 4;
        String expected = "231";
        String actual = obj.getPermutation(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int n = 4;
        int k = 2;
        String expected = "1243";
        String actual = obj.getPermutation(n, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int n = 4;
        int k = 9;
        String expected = "2314";
        String actual = obj.getPermutation(n, k);
        assertEquals(expected, actual);
    }
}
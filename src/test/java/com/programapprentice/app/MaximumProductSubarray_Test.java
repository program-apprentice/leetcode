package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/2/15
 * Time: 10:50 PM
 */
public class MaximumProductSubarray_Test {
    MaximumProductSubarray_152 obj = new MaximumProductSubarray_152();

    @Test
    public void test1() {
        int[] input = {2, 3, -2, 4, -2};
        int expected = 96;
        int actual = obj.maxProduct(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] input = {2, 3, -2, 4};
        int expected = 6;
        int actual = obj.maxProduct(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] input = {-2, -3, -2, -4};
        int expected = 48;
        int actual = obj.maxProduct(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] input = {-2,  0};
        int expected = 0;
        int actual = obj.maxProduct(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] input = {0, 2};
        int expected = 2;
        int actual = obj.maxProduct(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int[] input = {-5, 0, 2};
        int expected = 2;
        int actual = obj.maxProduct(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test7() {
        int[] input = {2,-5,-2,-4,3};
        int expected = 24;
        int actual = obj.maxProduct(input);
        assertEquals(expected, actual);
    }
}

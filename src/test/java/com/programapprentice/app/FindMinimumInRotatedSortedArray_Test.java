package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/3/15
 * Time: 10:51 PM
 */
public class FindMinimumInRotatedSortedArray_Test {
    FindMinimumInRotatedSortedArray_153 obj = new FindMinimumInRotatedSortedArray_153();

    @Test
    public void test1() {
        int[] input = {4, 5, 6, 7, 0, 1, 2, 3};
        int expected = 0;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] input = {2, 0};
        int expected = 0;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] input = {4, 5, 6, 7, 0, 1, 2};
        int expected = 0;
        int actual = obj.findMin(input);
        assertEquals(expected, actual);
    }
}

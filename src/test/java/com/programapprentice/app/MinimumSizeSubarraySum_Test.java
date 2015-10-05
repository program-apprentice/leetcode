package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/4/15
 * Time: 6:35 PM
 */
public class MinimumSizeSubarraySum_Test {
    MinimumSizeSubarraySum_209 obj = new MinimumSizeSubarraySum_209();
    @Test
    public void test1() {
        int[] input = {2,3,1,2,4,3};
        int target = 7;
        int expected = 2;
        int actual = obj.minSubArrayLen(target, input);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] input = {2,3,1,2,4,3};
        int target = 4;
        int expected = 1;
        int actual = obj.minSubArrayLen(target, input);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] input = {1, 4, 4};
        int target = 4;
        int expected = 1;
        int actual = obj.minSubArrayLen(target, input);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] input = {1,2,3,4,5};
        int target = 11;
        int expected = 3;
        int actual = obj.minSubArrayLen(target, input);
        assertEquals(expected, actual);
    }
}

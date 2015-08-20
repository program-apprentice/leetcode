package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/19/15
 * Time: 4:58 PM
 */
public class MaximumSubArray_Test {
    MaximumSubArray_53 obj = new MaximumSubArray_53();

    @Test
    public void test1() {
        int[] nums = {1, 2};
        int expected = 3;
        int actual = obj.maxSubArray(nums);
        assertEquals(expected, actual);
    }
}

package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 3:54 PM
 */
public class RemoveDuplicatesFromSortedArray_Test {
    RemoveDuplicatesFromSortedArray_26 obj = new RemoveDuplicatesFromSortedArray_26();
    @Test
    public void test1() {
        int[] nums = {1, 2, 2};
        int expected = 2;
        int actual = obj.removeDuplicates(nums);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = {2, 2, 2};
        int expected = 1;
        int actual = obj.removeDuplicates(nums);
        assertEquals(expected, actual);
    }
}

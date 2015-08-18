package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/17/15
 * Time: 9:08 PM
 */
public class SearchForARange_Test {
    SearchForARange_34 obj = new SearchForARange_34();
    @Test
    public void test1() {
        int[] nums = {1};
        int[] expected = {0, 0};
        int target = 1;
        int[] actual = obj.searchRange(nums, target);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    public void test2() {
        int[] nums = {1};
        int[] expected = {-1, -1};
        int target = 2;
        int[] actual = obj.searchRange(nums, target);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }

    @Test
    public void test3() {
        int[] nums = {3, 3, 3};
        int[] expected = {0, 2};
        int target = 3;
        int[] actual = obj.searchRange(nums, target);
        assertEquals(expected[0], actual[0]);
        assertEquals(expected[1], actual[1]);
    }
}

package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Assert;
import org.junit.Test;

/**
 * User: program-apprentice
 * Date: 10/13/15
 * Time: 10:32 PM
 */
public class SlidingWindowMaximum_Test {
    SlidingWindowMaximum_239 obj = new SlidingWindowMaximum_239();
    @Test
    public void test1() {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        int[] actual = obj.maxSlidingWindow(nums, k);
        int[] expected = {3, 3, 5, 5, 6, 7};
        Assert.assertArrayEquals(expected, actual);
        Util.printArrayInteger(actual);

    }

    @Test
    public void test2() {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 1;
        int[] actual = obj.maxSlidingWindow(nums, k);
        int[] expected = {1,3,-1,-3,5,3,6,7};
        Assert.assertArrayEquals(expected, actual);
        Util.printArrayInteger(actual);
    }

    @Test
    public void test3() {
        int nums[] = {1,3,-1,-3,5,3,6,7};
        int k = 2;
        int[] actual = obj.maxSlidingWindow(nums, k);
        int[] expected = {3, 3, -1, 5, 5, 6, 7};
        Assert.assertArrayEquals(expected, actual);
        Util.printArrayInteger(actual);
    }

    @Test
    public void test4() {
        int nums[] = {7, 2, 4};
        int k = 2;
        int[] actual = obj.maxSlidingWindow(nums, k);
        int[] expected = {7, 4};
        Assert.assertArrayEquals(expected, actual);
        Util.printArrayInteger(actual);
    }

    @Test
    public void test5() {
        int nums[] = {1,3,1,2,0,5};
        int k = 3;
        int[] actual = obj.maxSlidingWindow(nums, k);
        int[] expected = {3, 3, 2, 5};
        Assert.assertArrayEquals(expected, actual);
        Util.printArrayInteger(actual);
    }
}

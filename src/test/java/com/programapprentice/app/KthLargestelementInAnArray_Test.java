package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 10/5/15
 * Time: 9:56 PM
 */
public class KthLargestelementInAnArray_Test {
    KthLargestElementInAnArray_215 obj = new KthLargestElementInAnArray_215();
    @Test
    public void test1() {
        int[] input = {2, 1};
        int k = 2;
        int expected = 1;
        int actual = obj.findKthLargest(input, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] input = {-1, -1};
        int k = 2;
        int expected = -1;
        int actual = obj.findKthLargest(input, k);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] input = {-1, 2, 0};
        int k = 1;
        int expected = 2;
        int actual = obj.findKthLargest(input, k);
        assertEquals(expected, actual);
    }
}

package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 1:42 PM
 */
public class RemoveElement_Test {
    RemoveElement_27 obj = new RemoveElement_27();

    @Test
    public void test1() {
        int[] nums = {1, 2, 1, 1, 1};
        int val = 1;
        int expected = 1;
        int actual = obj.removeElement(nums, val);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 1, 1, 1};
        int val = 2;
        int expected = 4;
        int actual = obj.removeElement(nums, val);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        int[] nums = {1, 1, 1, 1, 1};
        int val = 1;
        int expected = 0;
        int actual = obj.removeElement(nums, val);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        int[] nums = {1};
        int val = 1;
        int expected = 0;
        int actual = obj.removeElement(nums, val);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        int[] nums = {2};
        int val = 3;
        int expected = 1;
        int actual = obj.removeElement(nums, val);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        int[] nums = {3, 3};
        int val = 5;
        int expected = 2;
        int actual = obj.removeElement(nums, val);
        assertEquals(expected, actual);
    }

}

package com.programapprentice.app;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: program-apprentice
 * Date: 8/17/15
 * Time: 8:14 PM
 */
public class NextPermutation_Test {
    NextPermutation_31 obj = new NextPermutation_31();
    @Test
    public void test1() {
        int[] nums = {1, 3, 2};
        obj.nextPermutation(nums);
        int[] expected = {2, 1, 3};
        for(int i = 0; i < 3; i++) {
            assertEquals(nums[i], expected[i]);
        }
    }


}

package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/13/15
 * Time: 9:54 PM
 */
public class SingleNumber_136 {
    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int result = nums[0];
        for(int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}

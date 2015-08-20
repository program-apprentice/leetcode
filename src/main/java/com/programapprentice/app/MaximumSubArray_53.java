package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/19/15
 * Time: 4:50 PM
 */
public class MaximumSubArray_53 {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(max > 0) {
                sum += cur;
                if(sum< 0) {
                    sum = 0;
                } else {
                    max = Math.max(sum, max);
                }
            } else {
                max = Math.max(max, cur);
                sum = max; // missing this line.
            }
        }

        return max;
    }
}
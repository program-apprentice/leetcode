package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 10/2/15
 * Time: 9:45 PM
 */
public class MaximumProductSubarray_152 {
    public int max3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public int maxProduct(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int totalMax = nums[0];
        int max = nums[0];
        int min = nums[0];
        int tmpMax = 0;
        int tmpMin = 0;

        for(int i = 1; i < nums.length; i++) {
            tmpMax = max;
            tmpMin = min;
            tmpMax *= nums[i];
            tmpMin *= nums[i];
            max = max3(nums[i], tmpMax, tmpMin);
            min = min3(nums[i], tmpMax, tmpMin);
            totalMax = Math.max(totalMax, max);
        }
        return totalMax;
    }
}

package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 10/4/15
 * Time: 9:58 PM
 */
public class HouseRobberII_213 {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }
        int n = nums.length;
        int[] rec = new int[n];
        rec[0] = nums[0];
        for(int i = 1; i < n; i++) {
            if(i == 1) {
                rec[i] = Math.max(rec[0], nums[i]);
            } else if(i == n-1) {
                rec[i] = rec[i-1];
            } else {
                rec[i] = Math.max(rec[i - 1], rec[i - 2] + nums[i]);
            }
        }

        int[] rec2 = new int[n];
        rec2[0] = 0;
        rec2[1] = nums[1];
        for(int i = 2; i < n; i++) {
            rec2[i] = Math.max(rec2[i - 1], rec2[i - 2] + nums[i]);
        }
        return Math.max(rec[n-1], rec2[n-1]);
    }
}

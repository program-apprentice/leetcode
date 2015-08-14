package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 10:29 PM
 * Finished Time: 11:11 PM
 */
public class HouseRobber_198 {
    public int max(int[] nums, int end) {
        int max = 0;
        for(int i = 0; i <= end; i++) {
            max = max > nums[i] ? max : nums[i];
        }
        return max;
    }

    public int rob_slow(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] tRec = new int[nums.length];
        int[] fRec = new int[nums.length];
        tRec[0] = nums[0];
        fRec[0] = 0;
        if(nums.length >= 2) {
            tRec[1] = nums[1];
            fRec[1] = nums[0];
        }

        for(int i = 2; i < nums.length; i++) {
            tRec[i] = Math.max(max(tRec, i-2), max(fRec, i-1)) + nums[i];
            fRec[i] = Math.max(max(fRec, i - 1), max(tRec, i - 1));
        }
        return Math.max(tRec[nums.length-1], fRec[nums.length-1]);
    }

    public int rob(int[] nums) {
        int length = nums.length;
        int[] rec = new int[length];
        rec[0] = nums[0];
        for(int i = 1; i < length; i++) {
            if(i == 1) {
                rec[i] = Math.max(rec[0], nums[i]);
            } else {
                rec[i] = Math.max(rec[i - 1], rec[i - 2] + nums[i]);
            }
        }
        return rec[length - 1];
    }
}

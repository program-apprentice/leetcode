package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/19/15
 * Time: 5:09 PM
 * Finished Time: 5:13 PM
 */
public class JumpGame_55 {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(max >= i) {
                max = Math.max(max, nums[i] + i);
            } else {
                break;
            }
        }
        return max >= nums.length-1; // wrong: max >= nums.length
    }
}

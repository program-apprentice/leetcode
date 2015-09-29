package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/28/15
 * Time: 11:20 PM
 */
public class FindPeakElement_162 {
    public int findPeakElement(int[] nums) {
        if(nums == null) {
            return -1;
        }
        if(nums.length == 1) {
            return 0;
        }
        int output = -1;
        if(nums[1] < nums[0]) {
            output = 0;
        }
        for(int i = 1; i < nums.length; i++) {
            if(i == nums.length-1) {
                if(nums[i-1] < nums[i]) {
                    output = i;
                }
            } else {
                if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                    return i;
                }
            }
        }

        return output;
    }
}

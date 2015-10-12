package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 10/11/15
 * Time: 7:47 PM
 */
public class ContainsDuplicateIII_220 {
    /**
     * Given an array of integers, find out whether there are two distinct indices i and j in the array
     * such that the difference between nums[i] and nums[j] is at most t and the difference
     * between i and j is at most k.
     * */
    public boolean containsNearbyAlmostDuplicateTwoSlow(int[] nums, int k, int t) {
        for(int i = 0; i < nums.length; i++) {
            for(int step = 0; step <= k && (i+step) < nums.length; step++) {
                if(Math.abs(nums[i] - nums[i+step]) < t) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0) {
            return false;
        }int n = nums.length;
        int[] record = new int[n];
        record[0] = 0;
        for(int i = 0; i < nums.length; i++) {
            
            for(int step = 0; step <= k && (i+step) < nums.length; step++) {
                if(Math.abs(nums[i] - nums[i+step]) < t) {
                    return true;
                }
            }
        }
        return false;
    }
}

package com.programapprentice.app;

import java.util.TreeSet;

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


    // TreeSet is a red-black tree implementation
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums == null || nums.length == 0) {
            return false;
        }
        if(k < 0 || t < 0) {
            return false;
        }
        int n = nums.length;
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            Integer floor = treeSet.floor(cur);
            if(floor != null && floor >= cur - t) {
                return true;
            }
            Integer ceiling = treeSet.ceiling(cur);
            if(ceiling != null && ceiling <= cur + t) {
                return true;
            }
            treeSet.add(cur);
            if(i >= k) {
                treeSet.remove(new Integer(nums[i-k]));
            }
        }
        return false;
    }
}

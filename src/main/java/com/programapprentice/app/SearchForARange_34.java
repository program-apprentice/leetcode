package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/17/15
 * Time: 8:26 PM
 * Finished Time: 9:35 PM
 */
/**
 Given a sorted array of integers, find the starting and ending position of a given target value.

 Your algorithm's runtime complexity must be in the order of O(log n).

 If the target is not found in the array, return [-1, -1].

 For example,
 Given [5, 7, 7, 8, 8, 10] and target value 8,
 return [3, 4].
 * */
public class SearchForARange_34 {
    /**
     * 1. find left start
     * 2. find right start
     * */
    public int[] searchRange(int[] nums, int target) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(nums == null || nums.length == 0) {
            return result;
        }
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        int left = -1;
        int right = -1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(nums[mid] > target) {
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                left = mid;
                high = mid-1;
            }
        }
        if(left == -1) {
            return result;
        }
        result[0] = left;
        result[1] = left;
        low = left+1;
        high = nums.length-1;
        while(low <= high) {
            mid = (low + high) / 2;
            if(nums[mid] > target) {
                high = mid - 1;
            } else if(nums[mid] < target) {
                low = mid + 1;
            } else {
                right = mid;
                low = mid+1;
            }
        }
        if(right != -1) {
            result[1] = right;
        }
        return result;
    }
}

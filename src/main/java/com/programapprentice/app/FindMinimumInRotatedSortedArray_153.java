package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 10/3/15
 * Time: 10:39 PM
 */
public class FindMinimumInRotatedSortedArray_153 {
    public int addOne(int mid, int length) {
        return (mid+1)% length;
    }

    public int substractOne(int mid, int length) {
        return (mid+length-1)% length;
    }

    public boolean isMinimum(int[] nums, int index) {
        if(nums[addOne(index, nums.length)] > nums[index]
                && nums[substractOne(index, nums.length)] > nums[index]) {
            return true;
        }
        return false;
    }

    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int low = 0;
        int high = nums.length-1;
        while(low < high) {
            int mid = (low + high) / 2;
            if(isMinimum(nums, low)) {
                return nums[low];
            }
            if(isMinimum(nums, mid)) {
                return nums[mid];
            }
            if(isMinimum(nums, high)) {
                return nums[high];
            }
            if(nums[mid] > nums[low]) {
                low = addOne(mid, nums.length);
            } else {
                high = substractOne(mid, nums.length);
            }
        }
        return nums[low];
    }
}

package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/17/15
 * Time: 9:39 PM
 * Finished Time: 10:11 PM
 */
public class SearchInsertPosition_35 {
    public int binarySearch(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        int mid = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            if(nums[mid] > target) { // before wrong is: mid > target
                high = mid - 1;
            } else if (nums[mid] < target) { // before wrong is : mid < target
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public boolean isBetween(int target, int low, int high) {
        return (target > low && target < high);
    }

    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int search = binarySearch(nums, target);
        if(search != -1) {
            return search;
        }
        int low = 0;
        int high = nums.length-1; // before is wrong: high = nums.length;
        int mid = 0;
        while(low <= high) {
            mid = (low + high) / 2;
            if(nums[mid] < target) { // before wrong is: mid < target
                if(mid != nums.length-1) {
                    if(isBetween(target, nums[mid], nums[mid+1])) {
                        return mid + 1;
                    } else {
                        low = mid + 1;
                    }
                } else {
                    return mid + 1;
                }
            } else {
                if(mid != 0) {
                    if(isBetween(target, nums[mid-1], nums[mid])) {
                        return mid; // wrong is: return mid - 1
                    } else {
                        high = mid - 1;
                    }
                } else {
                    return 0;
                }
            }
        }
        return 0;
    }
}

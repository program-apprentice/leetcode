package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 8:52 PM
 */
public class RotateArray_189 {
    public void rotate(int[] nums, int start, int end) {
        int low = start;
        int high = end;
        int tmp = 0;
        while(low < high) {
            tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }
    }

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if(0 == k) {
            return;
        }
        rotate(nums, 0, nums.length-1);
        rotate(nums, 0, k-1);
        rotate(nums, k, nums.length-1);
    }

}

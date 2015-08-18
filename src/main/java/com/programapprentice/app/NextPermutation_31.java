package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/17/15
 * Time: 7:36 PM
 */
/**
 Implement next permutation, which rearranges numbers into the lexicographically next
 greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order
 (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding
 outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 * */
public class NextPermutation_31 {
    public void reverse(int[] nums, int start) {
        int low = start;
        int high = nums.length-1;
        int tmp = 0;
        while(low < high) {
            tmp = nums[low];
            nums[low] = nums[high];
            nums[high] = tmp;
            low++;
            high--;
        }
    }
    public void nextPermutation(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int idx = nums.length-1;
        int pre = idx-1;
        while(pre >= 0 && nums[pre] >= nums[idx]) {
            pre--;
            idx--;
        }
        int start = 0;
        if(pre >= 0) {
            start = idx;
            idx = nums.length-1;
            while(nums[idx] <= nums[pre]) {
                idx--;
            }
            int tmp = nums[idx];
            nums[idx] = nums[pre];
            nums[pre] = tmp;
        }
        reverse(nums, start);
    }
}

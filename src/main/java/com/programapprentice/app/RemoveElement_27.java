package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 1:34 PM
 */
public class RemoveElement_27 {
    // Use high and low
    public int removeElement_v1(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0] == val ? 0 : 1;
        }
        int low = 0;
        int high = nums.length - 1;
        while(low < high) {
            if(nums[low] == val) {
                if(nums[high] == val) {
                    high --;
                } else {
                    nums[low] = nums[high];
                    nums[high] = val;
                    high--;
                    low++;
                }
            } else {
                low++;
            }
        }
        if(nums[low] == val) {
            return low;
        }
        return low + 1;
    }

    public int removeElement(int[] nums, int val) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int pos = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[pos] == val) {
                if(nums[i] != val) {
                    nums[pos] = nums[i];
                    nums[i] = val;
                    pos++;
                }
            } else {
                pos++;
            }
        }
        return pos;
    }

    public int removeElementSolution(int[] A, int elem) {
        if (A.length == 0)  return 0;
        int pos = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem)
                A[pos++] = A[i];
        }
        return pos;
    }
}

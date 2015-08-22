package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/21/15
 * Time: 6:17 PM
 */
public class SortColors_75 {
    public void sortColors(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return;
        }
        int one = 0;
        int two = nums.length-1;
        int tmp = 0;
        int i = 0;
        while(i < two) {
            if(nums[i] == 2) {
                if(nums[two] == 2) {
                    two--;
                } else {
                    tmp = nums[two];
                    nums[two] = nums[i];
                    nums[i] = tmp;
                    i++;
                    two--;
                }
            } else {
                i++;
            }
        }

        i = 0;
        one = nums[two] == 2 ? two-1 : two; // wrong: one = two;
        while(i < one) {
            if(nums[i] == 1) {
                if(nums[one] == 1) {
                    one--;
                } else {
                    tmp = nums[one];
                    nums[one] = nums[i];
                    nums[i] = tmp;
                    i++;
                    one--;
                }
            } else {
                i++;
            }
        }
    }

}

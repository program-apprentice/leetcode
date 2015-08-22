package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/21/15
 * Time: 7:02 PM
 */
public class RemoveDuplicatesFromSortedArrayII_80 {
    public int removeDuplicates(int nums[]) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int i = 1;
        int low = 0;
        int counter = 1;
        for(i = 1; i < nums.length; i++) {
            if(nums[i] == nums[low]) {
                if(counter == 2) {
                    nums[low] = nums[i];
                } else {
                    counter++;
                    low++;
                    nums[low] = nums[i];
                }
            } else {
                counter=1;
                low++;
                nums[low] = nums[i];
            }
        }

        return low+1;
    }
}

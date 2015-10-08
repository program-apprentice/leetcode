package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 10/7/15
 * Time: 8:47 PM
 */
public class MajorityElementII_229 {
    public List<Integer> majorityElement(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<Integer>();
        }
        int count1 = 0;
        int count2 = 0;
        int candidate1 = 0;
        int candidate2 = 0;
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(count1 == 0) {
                candidate1 = cur;
                count1 ++;
            } else if (cur != candidate1 && count2 == 0) {
                candidate2 = cur;
                count2++;
            } else if (cur == candidate1) {
                count1++;
            } else if (cur == candidate2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
        }
        List<Integer> output = new ArrayList<Integer>();
        if(isThird(nums, candidate1)) {
            output.add(candidate1);
        }
        if(candidate1 != candidate2 && isThird(nums, candidate2)) {
            output.add(candidate2);
        }
        return output;
    }


    public boolean isThird(int[] nums, int candidate) {
        int counter = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == candidate) {
                counter++;
            }
        }
        if(counter * 3 > nums.length) {
            return true;
        }
        return false;
    }
}

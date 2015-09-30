package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/29/15
 * Time: 8:03 PM
 */
public class MissingRanges_163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> output = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            if(upper > lower) {
                output.add(String.format("%d->%d", lower, upper));
            } else {
                output.add(String.format("%d", lower));
            }
            return output;
        }
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) {
                if(nums[i] > lower) {
                    if(lower == nums[i]-1) {
                        output.add(String.format("%d", lower));
                    } else {
                        output.add(String.format("%d->%d", lower, nums[i]-1));
                    }
                }
            } else {
                if(nums[i] > nums[i-1] + 1) {
                    if(nums[i] == nums[i-1] + 2) {
                        output.add(String.format("%d", nums[i-1]+1));
                    } else {
                        output.add(String.format("%d->%d", nums[i-1]+1, nums[i]-1));
                    }
                }
            }
        }
        if(nums[nums.length-1] < upper) {
            if(upper-1 == nums[nums.length-1]) {
                output.add(String.format("%d", upper));
            } else {
                output.add(String.format("%d->%d", nums[nums.length-1]+1, upper));
            }
        }
        return output;
    }
}

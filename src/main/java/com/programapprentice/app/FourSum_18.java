package com.programapprentice.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 1:54 PM
 * Finished Time: 3:11 PM
 */
public class FourSum_18 {
    public int move(int[] nums, int start, boolean isAsc) {
        if(isAsc) {
            while(start < nums.length-1 && nums[start+1] == nums[start]) {
                start ++;
            }
            start++;
        } else {
            while(start > 1 && nums[start-1] == nums[start]) {
                start --;
            }
            start--;
        }
        return start;
    }

    // nums is already sorted here.
    public List<List<Integer>> threeSum(int[] nums, int start, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        int goal = 0;
        int low = 0;
        int high = 0;
        int sum = 0;
        for(int i = start; i < nums.length-2; i++) { // i = start + 1, maximum is nums.length-2
            if(i > start && nums[i] == nums[i-1]) {
                continue;
            }
            goal = target - nums[i];
            low = i + 1; // low = start + 1 is wrong.
            high = nums.length - 1;
            while(low < high) {
                sum = nums[low] + nums[high];
                if(sum > goal) {
                    high = move(nums, high, false);
                } else if (sum < goal) {
                    low = move(nums, low, true);  // if num[low] == num[low+1], there will be duplicates.
                } else {
                    List<Integer> item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[low]);
                    item.add(nums[high]);
                    output.add(item);
                    low = move(nums, low, true);
                    high = move(nums, high, false);
                }
            }
        }
        return output;
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 4) {
            return output;
        }
        Arrays.sort(nums);

        int goal = 0;
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i-1] == nums[i]) { // condition is i > 0
                // skip duplicates
                continue;
            }
            goal = target - nums[i];
            List<List<Integer>> list = threeSum(nums, i+1, goal);
            if(!list.isEmpty()) {
                for(List<Integer> item : list) {
                    item.add(0, nums[i]);
                    output.add(item);
                }
            }
        }
        return output;
    }
}

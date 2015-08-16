package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 11:19 PM
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 Find all unique triplets in the array which gives the sum of zero.

 Note:
 Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
 The solution set must not contain duplicate triplets.
 For example, given array S = {-1 0 1 2 -1 -4},

 A solution set is:
 (-1, 0, 1)
 (-1, -1, 2)
 * */
public class ThreeSum_15 {
    // time complexity: O(n^2)
    public List<List<Integer>> threeSum_tooslow(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return output;
        }
        Arrays.sort(nums);
        HashMap<Integer, Integer> num2IdxMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            num2IdxMap.put(nums[i], i);
        }

        int goal = 0;
        for(int i = 0; i < nums.length; i++) {
            goal = 0 - nums[i];
            for(int j = i + 1; j < nums.length; j++) {
                if(num2IdxMap.get(goal - nums[j]) != null) {
                    int idx = num2IdxMap.get(goal = nums[j]);
                    if(idx > j) {
                        List<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        item.add(nums[j]);
                        item.add(nums[idx]);
                        output.add(item);
                    }
                }
            }
        }
        return output;
    }

    public List<List<Integer>> threeSum_slow2(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3 || nums[0] > 0) {
            return output;
        }
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length-1] < 0) {
            return output;
        }
        int goal = 0;
        int low = 0;
        int high = 0;
        int sum = 0;
        List<Integer> item = null;
        for(int i = 0; i < nums.length; i++) {
            if(i > 1 && nums[i] == nums[i-1]) {
                continue;
            }
            goal = 0 - nums[i];
            low = i+1;
            high = nums.length-1;
            while(low < high) {
                sum = nums[low] + nums[high];
                if(sum > goal) {
                    high--;
                } else if (sum < goal) {
                    low++;
                } else {
                    item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[low]);
                    item.add(nums[high]);
                    output.add(item);
                    low++;
                    high--;
                }
            }
        }
        return output;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) {
            return output;
        }
        Arrays.sort(nums);
        if(nums[0] > 0 || nums[nums.length-1] < 0) {
            return output;
        }

        int goal = 0;
        int low = 0;
        int high = 0;
        int sum = 0;
        List<Integer> item = null;
        for(int i = 0; i < nums.length; i++) {
            if(i > 1 && nums[i] == nums[i-1]) {
                continue;
            }
            goal = 0 - nums[i];
            low = i+1;
            high = nums.length-1;
            while(low < high) {
                sum = nums[low] + nums[high];
                if(sum > goal) {
                    high--;
                } else if (sum < goal) {
                    low++;
                } else {
                    item = new ArrayList<Integer>();
                    item.add(nums[i]);
                    item.add(nums[low]);
                    item.add(nums[high]);
                    output.add(item);
                    low++;
                    high--;
                }
            }
        }
        return output;
    }
}

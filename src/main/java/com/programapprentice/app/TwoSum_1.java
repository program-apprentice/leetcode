package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 2:27 PM
 * Finished Time: 2:39 PM
 */

import java.util.HashMap;

/**
 Given an array of integers, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 * */
public class TwoSum_1 {
    /**
     * 1. Index is 1 based not zero base.
     * Question:
     * 1. Is there duplicates in this array.
     * 2. What is result for {2, 7, 11, 15} target = 4
     * 3. What is result for {2, 2, 7, 11, 15} target = 4 (This question does not have duplicates.)
     * */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        if(nums == null || nums.length < 2) {
            return result;
        }
        HashMap<Integer, Integer> num2IdxMap = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            num2IdxMap.put(nums[i], i);
        }
        int idx1 = 0;
        int idx2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(num2IdxMap.get(target - nums[i]) != null) {
                idx1 = i+1;
                idx2 = num2IdxMap.get(target - nums[i]) + 1;
                if(idx1 == idx2) {
                    continue;
                }
                result[0] = Math.min(idx1, idx2);
                result[1] = Math.max(idx1, idx2);
                break;
            }
        }
        return result;
    }
}

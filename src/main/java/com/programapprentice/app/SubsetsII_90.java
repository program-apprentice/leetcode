package com.programapprentice.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/6/15
 * Time: 9:54 PM
 */
public class SubsetsII_90 {

    public List<List<Integer>> subsetStep(int[] nums, boolean[] rec, int k, int start) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(k == 0) {
            List<Integer> empty = new ArrayList<Integer>();
            output.add(empty); // missing this part
            return output;
        }
        if(start == nums.length) {
            return output;
        }
        int n = nums.length;
        if(k == 1) {
            for(int i = start; i < n; i++) {
                if(!rec[i]) {
                    if(i == start || (nums[i] != nums[i-1])) { // wrong:if(i == 0 || (nums[i] != nums[i-1])) {
                        List<Integer> item = new ArrayList<Integer>();
                        item.add(nums[i]);
                        output.add(item);
                    }
                }
            }
            return output; // missing this one
        }
        for(int i = start; i < n-k+1; i++) {
            if(!rec[i]) {
                if(i == start || (nums[i] != nums[i-1])) { // wrong: if(i == 0 || (nums[i] != nums[i-1])) {
                    rec[i] = true;
                    List<List<Integer>> tmp = subsetStep(nums, rec, k-1, i+1);
                    for(List<Integer> e : tmp) {
                        e.add(0, nums[i]);
                        output.add(e);
                    }
                    rec[i] = false;// missing this one;
                }
            }
        }
        return output;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums == null || nums.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(nums);
        boolean[] rec = new boolean[nums.length];
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        for(int i = 0; i <= nums.length; i++) {
            output.addAll(subsetStep(nums, rec, i, 0));
        }
        return output;
    }
}

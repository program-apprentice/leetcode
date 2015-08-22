package com.programapprentice.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/21/15
 * Time: 6:21 PM
 */
public class Subset_78 {
    public List<List<Integer>> subsetsWorker(int[] nums, int k, boolean[] rec, int start) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(k == 0 || start == nums.length) {
            return output;
        }
        for(int i = start; i < nums.length-k+1; i++) { // wrong for(int i = start; i < nums.length-k; i++) {
            if(rec[i]) {
                continue;
            }
            rec[i] = true;
            List<List<Integer>> tmp = subsetsWorker(nums, k-1, rec, i+1);

            if(tmp.isEmpty()) { // this check is important
                List<Integer> e = new ArrayList<Integer>();
                e.add(nums[i]);
                output.add(e);
            } else {
                for (List<Integer> e : tmp) {
                    e.add(0, nums[i]);
                    output.add(e);
                }
            }
            rec[i] = false;
        }

        return output;
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0) {
            return output;
        }
        Arrays.sort(nums);

        boolean[] rec = new boolean[nums.length];

        List<Integer> l = new ArrayList<Integer>();
        output.add(l);

        for(int i = 1; i <= nums.length; i++) {
            output.addAll(subsetsWorker(nums, i, rec, 0));
        }
        return output;
    }
}

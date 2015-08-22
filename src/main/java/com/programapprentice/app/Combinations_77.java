package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/21/15
 * Time: 10:01 PM
 */
public class Combinations_77 {
    public List<List<Integer>> combineWorder(int[] nums, int k, boolean[] rec, int start) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(k == 0 || start == nums.length) {
            return output;
        }
        for(int i = start; i < nums.length-k+1; i++) { // wrong for(int i = start; i < nums.length-k; i++) {
            if(rec[i]) {
                continue;
            }
            rec[i] = true;
            List<List<Integer>> tmp = combineWorder(nums, k - 1, rec, i + 1);

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

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();

        if(k == 0 || n == 0) {
            return output;
        }
        boolean[] rec = new boolean[n];
        int[] nums = new int[n];
        for(int i = 1; i <= n; i++) {
            nums[i-1] = i;
        }
        return combineWorder(nums, k, rec, 0);
    }
}

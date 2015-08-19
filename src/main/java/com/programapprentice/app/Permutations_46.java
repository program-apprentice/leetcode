package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/18/15
 * Time: 9:41 PM
 */
public class Permutations_46 {
    public List<List<Integer>> permute(int[] nums, int start) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(start == nums.length-1) {
            List<Integer> elem = new ArrayList<Integer>();
            elem.add(nums[start]);
            output.add(elem);
            return output;
        }
        List<List<Integer>> list = permute(nums, start+1);
        for(List<Integer> elem : list) {
            int numPositions = elem.size() + 1;
            for(int i = 0; i < numPositions; i++) {
                List<Integer> item = new ArrayList<Integer>(elem);
                item.add(i, nums[start]);
                output.add(item);
            }
        }
        return output;
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(nums==null || nums.length == 0) {
            return output;
        }

        return permute(nums, 0);
    }
}

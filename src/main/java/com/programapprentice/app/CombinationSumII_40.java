package com.programapprentice.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/18/15
 * Time: 6:27 PM
 */
public class CombinationSumII_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target, boolean[] used, int min) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        for(int i = 0; i < candidates.length; i++) {
            if(candidates[i] > target) {
                break;
            }
            if(used[i] || candidates[i] < min || (i > 0 && !used[i-1] && candidates[i] == candidates[i-1])) {
                // This if check
                continue;
            } else {
                if(candidates[i] == target) {
                    List<Integer> elem = new ArrayList<Integer>();
                    elem.add(target);
                    output.add(elem);
                } else {
                    used[i] = true;
                    List<List<Integer>> list = combinationSum2(candidates, target-candidates[i], used, candidates[i]);
                    used[i] = false;
                    if(!list.isEmpty()) {
                        for(List<Integer> item : list) {
                            item.add(0, candidates[i]);
                            output.add(item);
                        }
                    }
                }
            }
        }
        return output;
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return new ArrayList<List<Integer>>();
        }
        Arrays.sort(candidates);
        boolean[] rec = new boolean[candidates.length];
        return combinationSum2(candidates, target, rec, 0);
    }
}

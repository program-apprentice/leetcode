package com.programapprentice.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/17/15
 * Time: 10:12 PM
 * Finished Time: 11:00 PM
 */
/**
 Given a set of candidate numbers (C) and a target number (T),
 find all unique combinations in C where the candidate numbers sums to T.

 The same repeated number may be chosen from C unlimited number of times.

 Note:
 All numbers (including target) will be positive integers.
 Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
 The solution set must not contain duplicate combinations.
 For example, given candidate set 2,3,6,7 and target 7,
 A solution set is:
 [7]
 [2, 2, 3]
 * */
public class CombinationSum_39 {
    public List<List<Integer>> combinationStep(int[] candidates, int target, int minimum) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(target < 0) {
            return output;
        }
        for(int i = 0; i < candidates.length; i++) {
            if(candidates[i] < minimum) {
                // avoid 2 3 2 for 7
                continue;
            }
            if(i > 0 && candidates[i] == candidates[i-1]) {
                continue;
            }
            if(target == candidates[i]) {
                List<Integer> elem = new ArrayList<Integer>();
                elem.add(candidates[i]);
                output.add(elem);
                break;
            } else if (target > candidates[i]) {
                List<List<Integer>> items = combinationStep(candidates, target - candidates[i], candidates[i]);
                if(!items.isEmpty()) {
                    for (List<Integer> l : items) {
                        List<Integer> lc = new ArrayList<Integer>(l);
                        lc.add(0, candidates[i]);
                        output.add(lc);
                    }
                }
            } else {
                break;
            }
        }

        return output;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return combinationStep(candidates, target, 0);
    }
}

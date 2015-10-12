package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 10/11/15
 * Time: 6:34 PM
 */
public class CombinationSumIII_216 {
    private int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n, int minimum) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(n <= minimum) {
            return null;
        }
        if(k == 1) {
            if((n < 1 || n > 9) || n <= minimum) {
                return null;
            }
            List<Integer> list = new ArrayList<Integer>();
            list.add(n);
            output.add(list);
            return output;
        }
        for(int i = 0; i < candidates.length; i++) {
            if(n-candidates[i] <= minimum || candidates[i] <= minimum) {
                continue;
            }
            List<List<Integer>> tmp = combinationSum3(k-1, n-candidates[i], candidates[i]);
            if(tmp != null && !tmp.isEmpty()) {
                for(List<Integer> item : tmp) {
                    item.add(0, candidates[i]);
                    output.add(item);
                }
            }
        }
        return output;
    }

    public List<List<Integer>> combinationSum3(int k, int n) {
        return combinationSum3(k, n, 0);
    }
}

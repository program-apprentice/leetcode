package com.programapprentice.app;

import java.util.HashMap;
import java.util.HashSet;

/**
 * User: program-apprentice
 * Date: 8/14/15
 * Time: 10:44 PM
 * Finished Time: 10:48 PM
 */
public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length <= 1) {
            return false;
        }
        HashSet<Integer> set = new HashSet<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }
}

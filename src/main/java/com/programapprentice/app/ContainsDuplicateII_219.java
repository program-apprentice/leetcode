package com.programapprentice.app;

import java.util.HashMap;

/**
 * User: program-apprentice
 * Date: 8/14/15
 * Time: 10:52 PM
 * Finished Time: 10:59 PM
 */
public class ContainsDuplicateII_219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums == null || nums.length <= 1) {
            return false;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(map.get(cur) == null) {
                map.put(cur, i);
            } else {
                if(i - map.get(cur) <= k) {
                    return true;
                } else {
                    map.put(cur, i);
                }
            }
        }
        return false;
    }
}

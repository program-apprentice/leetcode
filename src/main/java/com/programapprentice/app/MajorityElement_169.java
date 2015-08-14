package com.programapprentice.app;

import java.util.HashMap;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 6:39 PM
 * Finished time: 7:47 PM
 */
public class MajorityElement_169 {
    public int majorityElement(int[] nums) {
        if(nums == null) {
            return 0;
        }
        int halfLength = nums.length / 2;
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int counter = 0;
        int i = 0;
        for(; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                counter = map.get(nums[i]) +1;
            } else {
                counter = 1;
            }
            if(counter >= halfLength) {
                break;
            }
            map.put(nums[i], counter);
        }
        return nums[i];
    }
}

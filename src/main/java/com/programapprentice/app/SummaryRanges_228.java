package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 12:05 PM
 */
public class SummaryRanges_228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> output = new ArrayList<String>();
        if(nums == null || nums.length == 0) {
            return output;
        }
        int start = nums[0];
        int pre = nums[0];
        int cur = nums[0];
        for(int i = 1; i < nums.length; i++) {
            cur = nums[i];
            if(cur - pre != 1) {
                if(pre == start) {
                    output.add(String.format("%d", start));
                } else {
                    output.add(String.format("%d->%d", start, pre));
                }
                start = cur;
            }
            pre = cur;
        }
        if(start == cur) {
            output.add(String.format("%d", cur));
        } else {
            output.add(String.format("%d->%d", start, cur));
        }
        return output;
    }
}

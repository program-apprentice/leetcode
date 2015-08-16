package com.programapprentice.app;

import java.util.Arrays;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 1:02 AM
 */
/**
 Given an array S of n integers, find three integers in S such that the sum is closest
 to a given number, target. Return the sum of the three integers. You may assume that
 each input would have exactly one solution.

 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * */
public class ThreeSumClosest_16 {
    public int threeSumClosest(int[] num, int target) {
        if(num == null || num.length < 3) {
            return 0;
        }
        Arrays.sort(num);
        int diff = Integer.MAX_VALUE;
        int closest = 0;
        int low = 0;
        int high = 0;
        int goal = 0;
        int sum = 0;

        for(int i = 0; i < num.length-2; i++) {
            goal = target - num[i];
            low = i +1;
            high = num.length - 1;
            while(low < high) {
                sum = num[low] + num[high];
                if(sum > goal) {
                    if(diff > (sum - goal)) {
                        closest = sum + num[i];
                        diff = sum - goal;
                    }
                    high--;
                } else if (sum < goal) {
                    if(diff > (goal - sum)) {
                        closest = sum + num[i];
                        diff = goal - sum;
                    }
                    low++;
                } else {
                    return target;
                }
            }
        }
        return closest;
    }
}

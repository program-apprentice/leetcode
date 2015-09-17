package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/13/15
 * Time: 10:34 PM
 */
public class SingleNumberII_137 {

    public int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        int[] rec = new int[32]; // rec[0] is the lowest digit.
        for(int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            for(int j = 0; j < rec.length; j++) {
                int binary = cur & 1;
                rec[j] += binary;
                cur >>= 1;
            }
        }
        int value = 0;
        int shift = 1;
        for(int i = 0; i < rec.length; i++) {
            int binary = rec[i] % 3;
            value += binary * shift;
            shift <<= 1;
        }
        return value;
    }
}

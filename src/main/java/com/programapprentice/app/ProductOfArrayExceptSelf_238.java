package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 10/10/15
 * Time: 4:40 PM
 */
public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        if(nums == null) {
            return null;
        }
        int[] output = new int[nums.length];
        output[0] = 1;
        for(int i = 1; i < nums.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }
        int next = nums[nums.length-1];
        for(int i = nums.length-2; i >= 0; i--) {
            output[i] = output[i] * next;
            next *= nums[i];
        }
        return output;
    }
}

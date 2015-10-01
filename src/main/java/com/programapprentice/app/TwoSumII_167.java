package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/30/15
 * Time: 7:40 PM
 */
public class TwoSumII_167 {
    public int[] twoSum(int[] input, int goal) {
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if(input == null || input.length < 2) {
            return result;
        }

        int low = 0;
        int high = input.length - 1;
        int tSum = 0;
        while(low < high) {
            tSum = input[low] + input[high];
            if(tSum > goal) {
                high--;
            } else if (tSum < goal) {
                low++;
            } else {
                result[0] = low+1;
                result[1] = high+1;
                return result;
            }
        }
        return result;
    }
}

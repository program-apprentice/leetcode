package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 6:56 PM
 * FinishedTim:
 * https://leetcode.com/problems/factorial-trailing-zeroes/
 */
public class FactorialTrailingZeros_172 {

    public int trailingZeroes(int n) {
        if(n == 0) {
            return 0;
        }
        int count = 0;
        while(n > 0) {
            n = n/5;
            count += n;
        }
        return count;
    }
}

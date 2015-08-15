package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 12:44 PM
 */
public class PowerOfTwo_231 {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) {
            return false;
        }
        if(n == Integer.MIN_VALUE) {
            return false;
        }
        n = Math.abs(n);
        int counter = 0;
        while(n != 0) {
            counter += n & 1;
            n = n >> 1;
        }
        return counter == 1;
    }
}

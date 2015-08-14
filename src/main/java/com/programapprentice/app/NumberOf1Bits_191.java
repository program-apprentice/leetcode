package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 10:17 PM
 */
public class NumberOf1Bits_191 {
    public int hammingWeight(int n) {
        int counter = 0;
        for(int i = 0; i < 32; i++) {
            counter += n & 1;
            n = n >> 1;
        }
        return counter;
    }
}

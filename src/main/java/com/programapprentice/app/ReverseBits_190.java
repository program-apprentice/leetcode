package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 9:57 PM
 */
public class ReverseBits_190 {
    public int reverseBits(int n) {
        int output = 0;
        int tmp = 0;
        for(int i = 0; i < 32; i++) {
            tmp = n & 1;
            output = (output << 1) + tmp;
            n = n >> 1;
        }
        return output;
    }

}

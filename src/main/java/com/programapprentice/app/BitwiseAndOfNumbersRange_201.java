package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 10/1/15
 * Time: 7:55 PM
 */
public class BitwiseAndOfNumbersRange_201 {
    public int rangeBitwiseAnd(int m, int n) {
        int x = m ^ n;
        int s = x;
        while(s > 0) { // wrong: while(s != 0)
            x = x | s;
            s = s >> 1;
        }
        return m & n & (~x);
    }
}

package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 7:04 PM
 */
/**
 * 1. divident is Integer.MIN_VALUE
 * 2. divisor is Integer.MIN_VALUE
 * Find N such that
 * divisor * 2 ^ N < dividend < divisor * 2 ^ (N + 1)
 * Then
 * result += 2 ^ N
 * divendd -= divisor * 2 ^ N
 * */
public class DivideTwoIntegers_29 {
    public long posDivide(long dividend, long divisor) {
        // dividend and divisor are both positive.
        if(dividend < divisor) {
            return 0;
        }
        int result = 0;
        long base = divisor;
        int tResult = 1;
        while(dividend >= base) { // Don's miss equal sign.
            dividend -= base;
            result += tResult;
            tResult = tResult << 1;
            base = base << 1;
        }
        result += posDivide(dividend, divisor);
        return result;
    }

    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == 0) {
            return 0;
        }
        if(divisor == 1) {
            return dividend;
        }
        if(divisor == -1) {
            return (dividend == Integer.MIN_VALUE ? Integer.MAX_VALUE : -dividend);
        }
        boolean isNegative = false;
        if((dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0)) {
            isNegative = false;
        } else {
            isNegative = true;
        }
        long p = (long)dividend;
        long q = (long)divisor;
        long result = posDivide((long)Math.abs(p), (long)Math.abs(q));
        if(isNegative) {
             result = 0 - result;
        }
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if(result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int)result;
    }



 }

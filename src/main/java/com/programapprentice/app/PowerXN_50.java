package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/19/15
 * Time: 4:47 PM
 */
public class PowerXN_50 {
    public double posMyPow(double x, int n) {
        double tmp =  myPow(x, n/2);
        if(n%2 == 1) {
            return tmp * tmp * x;
        } else {
            return tmp * tmp;
        }
    }

    public double myPow(double x, int n) {
        if(n == 0) {
            return 1.0;
        }
        if(n == 1) {
            return x;
        }
        boolean isNegative = n < 0;
        boolean isMin = n == Integer.MIN_VALUE;
        if(isNegative) {
            if(isMin) {
                n = n + 1;
            }
            n = Math.abs(n);
        }
        double tmp = posMyPow(x, n);
        if(isNegative) {
            if(isMin) {
                tmp *= x;
            }
            return 1 / tmp;
        } else {
            return tmp;
        }
    }
}

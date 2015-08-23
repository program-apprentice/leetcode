package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/22/15
 * Time: 9:13 PM
 */
public class Sqrt_69 {

    public int mySqrt(int x) {
        if(x <= 0) {
            return 0;
        }
        if(x == 1) {
            return 1;
        }
        int low = 1;
        int high = x;
        int mid = 0;
        while(low < high) {
            mid = (low + high) / 2;
            int div = x / mid;

            if(div > mid) {
                low = mid + 1;
            } else if(div < mid) {
                high = mid;
            } else {
                return mid;
            }
        }
        return low - 1;
    }
}

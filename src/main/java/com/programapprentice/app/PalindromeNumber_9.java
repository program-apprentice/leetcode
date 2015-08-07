package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/6/15
 * Time: 10:06 PM
 */
public class PalindromeNumber_9 {
    public boolean isPalindrome(int x) {
        if(x < 0) {
            return false;
        }
        int num = x;
        int val = 0;
        while(num != 0) {
            val = val * 10 + num % 10;
            num /= 10;
        }
        return val == x;
    }
}

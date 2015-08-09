package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 11:22 PM
 */

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 *
 * The digits are stored such that the most significant digit is at the head of the list.
 * */
public class PlusOne_66 {
    /**
     * 1. carry
     * */
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int tmp = 0;
        for(int i = digits.length-1; i >= 0; i--) {
            tmp = digits[i] + carry;
            digits[i] = tmp % 10;
            carry = tmp / 10;
        }
        if(carry == 1) {
            int[] buffer = new int[1 + digits.length];
            buffer[0] = carry;
            for(int i = 0; i < digits.length; i++) {
                buffer[1+i] = digits[i];
            }
            digits = buffer;
        }
        return digits;
    }
}

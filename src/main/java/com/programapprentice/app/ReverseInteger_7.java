package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/4/15
 * Time: 10:01 PM
 */

import java.util.Stack;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * */
public class ReverseInteger_7 {
    public int reverse_v1(int x) {
        if(x == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        boolean isNegative = false;
        if(x < 0) {
            isNegative = true;
        }
        while(x != 0) {
            stack.push(x % 10);
            x /= 10;
        }
        int result = 0;
        int step = 1;
        int length = 1;
        while(!stack.isEmpty()) {
            if(length == 10) {
                // judge for overflow
                if(stack.peek() > 2 || stack.peek() < -2) {
                    return 0;
                } else {
                    if(isNegative) {
                        if(Integer.MIN_VALUE - stack.peek() * step > result) {
                            return 0;
                        }
                    } else {
                        if(Integer.MAX_VALUE - stack.peek() * step < result) {
                            return 0;
                        }
                    }
                }
            }
            length ++;
            result += stack.pop() * step;
            step *= 10;
        }
        return result;
    }


    public int reverse_v2(int x) {
        if(x == 0) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        boolean isNegative = false;
        if(x < 0) {
            isNegative = true;
        }
        while(x != 0) {
            stack.push(x % 10);
            x /= 10;
        }
        int result = 0;
        int step = 1;
        int tmpValue = 0;
        int maxThreshold = Integer.MAX_VALUE / 10;
        int minThreshold = Integer.MIN_VALUE / 10;
        while(!stack.isEmpty()) {
            tmpValue = stack.peek() * (step / 10);
            if(isNegative) {
                if(tmpValue < minThreshold || Integer.MIN_VALUE - tmpValue * 10 > result) {
                    return 0;
                }
            } else {
                if(tmpValue > maxThreshold || Integer.MAX_VALUE - tmpValue * 10 < result) {
                    return 0;
                }
            }
            result += stack.pop() * step;
            step *= 10;
        }
        return result;
    }

    public int reverse(int x) {
        int val = 0;
        int num = x;
        while(num != 0) {
            if(Math.abs(val) > Integer.MAX_VALUE /10) {
                return 0;
            }
            val = val * 10 + num % 10;
            num /= 10;
        }
        return val;
    }
}

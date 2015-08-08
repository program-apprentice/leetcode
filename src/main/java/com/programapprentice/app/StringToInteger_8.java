package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/7/15
 * Time: 10:18 PM
 */
public class StringToInteger_8 {
    /**
     * 1. Is Negative, check the first character
     * 2. Overflow check, return Integer.MIN_VALUE, or Integer.MAX_VALUE
     * 3. Invalid character check? then break, retrun parsed integer
     * 4. If there is space then continue
     * */

    public boolean isNumber(char c) {
        return (c >= '0' && c <= '9');
    }

    public int myAtoi(String str) {
        if(str == null) {
            return 0;
        }
        str = str.trim();
        boolean isNegative = false;
        int result = 0;
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(i == 0) {
                if(c == '-') {
                    isNegative = true;
                } else if (c == '+') {
                    isNegative = false;
                } else if (!isNumber(c)) {
                    return 0;
                } else {
                    result = c - '0';
                }
            } else {
                if(!isNumber(c)) {
                    break;
                }
                // overflow check
                if(isNegative) {
                    if(result < Integer.MIN_VALUE / 10) {
                        return Integer.MIN_VALUE;
                    } else {
                        if(Integer.MIN_VALUE - result * 10 > ('0' - c)) {
                            return Integer.MIN_VALUE;
                        }
                    }
                    result = result * 10 + ('0' - c);
                } else {
                    if(result > Integer.MAX_VALUE / 10) {
                        return Integer.MAX_VALUE;
                    } else {
                        if((Integer.MAX_VALUE - result * 10) < (c - '0')) {
                            return Integer.MAX_VALUE;
                        }
                    }
                    result = result * 10 + (c - '0');
                }

            }
        }
        return result;
    }
}

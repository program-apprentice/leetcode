package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 11:32 PM
 */
/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * */
public class AddBinary_67 {
    public String addBinary(String a, String b) {
        if(a == null || a.length() == 0) {
            return b;
        }
        if(b == null || b.length() == 0) {
            return a;
        }
        int maxLen = a.length() > b.length() ? a.length() : b.length();
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int digit = 0;
        int sum = 0;
        for(int i = 0; i < maxLen; i++) {
            int da = i < a.length() ? a.charAt(a.length() - 1 - i) - '0' : 0;
            int db = i < b.length() ? b.charAt(b.length() - 1 - i) - '0' : 0;
            sum = da + db + carry;
            digit = sum % 2;
            carry = sum / 2;
            sb.append(digit);
        }
        if(carry > 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}

package com.programapprentice.app;

import java.util.HashMap;

/**
 * User: program-apprentice
 * Date: 8/18/15
 * Time: 6:29 PM
 */
public class MultiplyStrings_43 {
    public String addStrings(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return null;
        }
        if(s1.equals("")) {
            return s2;
        }
        if(s2.equals("")) {
            return s1;
        }
        int maxLength = Math.max(s1.length(), s2.length());
        char[] buffer = new char[maxLength+1];
        int minLength = Math.min(s1.length(), s2.length());
        int i = 0;
        int l1 = s1.length();
        int l2 = s2.length();
        int l = maxLength + 1;
        int carry = 0;
        int tmp = 0;
        for(i = 0; i < minLength; i++) {
            tmp = char2int(s1.charAt(l1-1-i)) + char2int(s2.charAt(l2-i-1)) + carry;
            buffer[l - i - 1] = int2char(tmp % 10);
            carry = tmp / 10;
        }
        String s = null;
        if(s2.length() > minLength) {
            s = s2;
        } else {
            s = s1;
        }
        for(; i < maxLength; i++) {
            tmp = char2int(s.charAt(s.length()-1-i)) + carry;
            buffer[l-i-1] = int2char(tmp % 10);
            carry = tmp / 10;
        }
        buffer[0] = int2char(carry);
        if(carry == 0) {
            return new String(buffer, 1, buffer.length-1);
        } else {
            return new String(buffer);
        }
    }

    public int char2int(char c) {
        return c - '0';
    }

    public char int2char(int i) {
        return (char)('0' + i);
    }

    public String charMultiply(String s, char c) {
        if(c == '0') {
            return "0";
        }
        char[] buffer = new char[s.length() + 1];
        int carry = 0;
        int multiply = 0;
        int i = 0;
        for(i = s.length()-1; i >= 0; i--) {
            multiply = char2int(s.charAt(i)) * char2int(c) + carry;
            buffer[i+1] = int2char(multiply % 10);
            carry = multiply / 10;
        }
        buffer[0] = int2char(carry);
        if(carry == 0) {
            return new String(buffer, 1, buffer.length-1);
        } else {
            return new String(buffer);
        }
    }

    public String multiply(String s1, String s2) {
        if(s1 == null || s2 == null) {
            return null;
        }
        if(s1.isEmpty() || s2.isEmpty()) {
            return "";
        }
        if(s1.equals("0") || s2.equals("0")) {
            return "0";
        }
        HashMap<Character, String> record = new HashMap<Character, String>();
        String zeros = "";
        String newString = "";
        for(int i = s2.length()-1; i >= 0; i--) {
            char c = s2.charAt(i);
            String rec = record.get(c);
            if(rec == null) {
                rec = charMultiply(s1, c);
                record.put(c, rec);
            }
            rec = rec + zeros;
            newString = addStrings(newString, rec);
            zeros += "0";
        }
        return newString;
    }
}

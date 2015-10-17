package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 10/15/15
 * Time: 6:49 PM
 */
public class ShortestPalindrome_214 {
    public boolean isPalindrome(String s, int start, int end) {
        if(start == end) {
            return true;
        }
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }


    public String shortestPalindromeTooSlow(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        int length = s.length();
        int i = 0;
        for(i = length-1; i >= 0; i--) {
            if(isPalindrome(s, 0, i)) {
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int j = length-1; j > i; j--) {
            sb.append(s.charAt(j));
        }
        sb.append(s);
        return sb.toString();
    }


    ///////////////////////
    public String preProcess(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append("^");
        sb.append("#");
        for(int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            sb.append("#");
        }
        sb.append("$");
        return sb.toString();
    }

    public String shortestPalindrome(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        String t = preProcess(s);
        int length = t.length();
        int[] record = new int[length];
        int halfLength = length / 2;
        int rightIdx = 0;
        int centerIdx = 0;
        int max = 0;
        int center = 0;
        for(int i = 1; i <= halfLength; i++) {
            int iMirror = 2 * centerIdx - i; // iMirror = centerIdx - (i - centerIdx);
            if(rightIdx > i) {
                record[i] = Math.min(record[iMirror], rightIdx-i);
            } else {
                record[i] = 0;
            }

            while(t.charAt(i+1+record[i]) == t.charAt(i-1-record[i])) {
                record[i] += 1;
            }
            if(i + record[i] > rightIdx) {
                centerIdx = i;
                rightIdx = i + record[i];
                if((i - record[i])/2 == 0 && record[i] > max ) {
                    max = record[i];
                    center = i;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        int start = (center - max) / 2;
        int end = start + max - 1;
        sb.append(s.substring(end+1));
        sb.reverse();
        sb.append(s);
        return sb.toString();
    }
}

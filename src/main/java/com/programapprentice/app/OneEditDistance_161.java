package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/29/15
 * Time: 7:37 PM
 */
public class OneEditDistance_161 {
    public boolean isOneCharDiff(String s, String t) {
        int n = s.length();
        int diffNum = 0;
        for(int i = 0; i < n; i++) {
            if(s.charAt(i) != t.charAt(i)) {
                diffNum ++;
            }
        }
        return diffNum == 1;
    }

    // length of s is less then t
    public boolean isInsertionOneDiff(String s, String t) {
        if(t.length() != s.length()+1) {
            return false;
        }
        int low1 = 0;
        int low2 = 0;
        while(low1 < s.length() && low2 < t.length()) {
            if(s.charAt(low1) == t.charAt(low2)) {
                low1++;
                low2++;
            } else {
                low2++;
            }
        }
        if(low1 == s.length()) { // missing this section
            if(t.length() - low2 == 1) {
                return true;
            }
        }
        return (low1 == s.length() && low2 == t.length());
    }

    /**
     * 1. length is the same, change 1 char and get the other
     * 2. length diffis 1, insert one and get the other
     * */
    public boolean isOneEditDistance(String s, String t) {
        if(s == null || t == null) {
            return false;
        }
        boolean tmp = false;
        if(s.length() == t.length()) {
            tmp = isOneCharDiff(s, t);
            if(tmp) {
                return true;
            }
        }
        if(s.length() > t.length()) {
            String r = s;
            s = t;
            t = r;
        }
        return isInsertionOneDiff(s, t);
    }
}

package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 5:22 PM
 */
public class StrStr_28 {
    // brute force solution
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) {
            return 0;
        }
        if(needle.length() > haystack.length() || needle.length() == 0) {
            return -1;
        }

        for(int i = 0; i < haystack.length(); i++) {
            for(int j = 0; j < needle.length(); j++) {
                if(i + j >= haystack.length()) {
                    return -1;
                }
                if(haystack.charAt(i+j) != needle.charAt(j)) {
                    break;
                } else {
                    if(j == needle.length()-1) {
                        return i;
                    }
                }
            }
        }
        return -1;
    }
}

package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/7/15
 * Time: 11:11 PM
 */
public class LongestCommonPrefix_14 {
    public boolean isValidIndex(String[] strs, int i) {
        for(String s : strs) {
            if(s.length() < i) {
                return false;
            }
        }
        return true;
    }

    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) {
            return "";
        }
        StringBuffer sb = new StringBuffer();
        int index = 1;
        while(isValidIndex(strs, index)) {
            char c = strs[0].charAt(index - 1);
            for(String s : strs) {
                if(s.charAt(index-1) != c) {
                    return sb.toString();
                }
            }
            sb.append(c);
            index++;
        }
        return sb.toString();
    }
}

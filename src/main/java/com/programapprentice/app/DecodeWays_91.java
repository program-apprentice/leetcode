package com.programapprentice.app;


/**
 * User: program-apprentice
 * Date: 8/23/15
 * Time: 3:17 PM
 */
public class DecodeWays_91 {
    // exceed time limit
    public int numDecodings_V1(String s) {
        if(s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }
        int t1 = 0;
        int t2 = 0;
        String sub = null;
        sub = s.substring(1);
        if(sub.isEmpty()) {
            t1 = 1;
        } else {
            t1 = numDecodings_V1(sub);

            sub = s.substring(2);
            if (Integer.valueOf(s.substring(0, 2)) <= 26 &&
                    Integer.valueOf(s.substring(0, 2)) >= 10) {
                if(sub.isEmpty()) {
                    t2 = 1;
                } else {
                    t2 = numDecodings_V1(sub);
                }
            }
        }
        return t1+ t2;
    }

    // search in reverse
    public int numDecodings(String s) {
        if(s == null || s.isEmpty() || s.charAt(0) == '0') {
            return 0;
        }
        int[] rec = new int[s.length()+1];
        rec[0] = 1;
        for(int i = 1; i <= s.length(); i++) {
            if(s.charAt(i-1) != '0') {
                rec[i] += rec[i-1];
            }
            if(i >= 2 && (s.charAt(i-2) == '1' || (s.charAt(i-2) == '2' && s.charAt(i-1) <= '6'))) {
                rec[i] += rec[i-2];
            }
        }
        return rec[s.length()];
    }
}

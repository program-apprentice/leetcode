package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 5:33 PM
 */
public class LongestPalindromicSubstring_5 {

    // brute force
    public String longestPalindrome_bruteforce(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        String max = s.substring(0, 0);
        int low = 0;
        int high = 0;
        for(int i = 0; i < s.length(); i ++) {
            low = i;
            for(int j = s.length()-1; j >= i; j--) {
                while(low <= high) {
                    if(s.charAt(low) != s.charAt(high)) {
                        break;
                    }
                    low++;
                    high--;
                }
                if(low > high) {
                    max = max.length() > (j-i+1) ? max : s.substring(i, j);
                }
            }
        }
        return max;
    }


    // center is center
    public String func1(String s, int center) {
        if(center == 0) {
            return s.substring(0, 1);
        }
        int low = center - 1;
        int high = center + 1;
        while(low >= 0 && high < s.length()) {
            if(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            } else {
                break;
            }
        }
        return s.substring(low+1, high);
    }

    // center is center and center+1
    public String func2(String s, int center) {
        if(center == s.length()-1) {
            return s.substring(center, s.length());
        }
        int low = center;
        int high = center + 1;
        while(low >= 0 && high < s.length()) {
            if(s.charAt(low) == s.charAt(high)) {
                low--;
                high++;
            } else {
                break;
            }
        }
        return s.substring(low+1, high);
    }


    // complexity is O(n^2)
    public String longestPalindrome_manacher(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        char[] cs = s.toCharArray();
        int len = s.length();
        String max = s.substring(0, 0);
        for(int i = 0; i < len; i++) {
            // i is center
            String s1 = func1(s, i);
            max = max.length() > s1.length() ? max : s1;
            // center is between i and i+1
            String s2 = func2(s, i);
            max = max.length() > s2.length() ? max : s2;
        }
        return max;
    }

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

    // complexity is O(n)
    // http://articles.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
    // http://www.felix021.com/blog/read.php?2040 (better explaination)
    public String longestPalindromeManacher(String s) {
        if(s == null || s.length() <= 1) {
            return s;
        }
        String t = preProcess(s);
        int n = t.length();
        int[] record = new int[n];
        int centerIdx = 0;
        int rightIdx = 0;
        for(int i = 1; i < n-1; i++) {
            int iMirror = 2 * centerIdx - i;
            if(rightIdx > i) {
                record[i] = Math.min(rightIdx-i, record[iMirror]);
            } else {
                record[i] = 0;
            }

            while(t.charAt(i+1+record[i]) == t.charAt(i-1-record[i])) {
                record[i]++;
            }

            if(i + record[i] > rightIdx) {
                centerIdx = i;
                rightIdx = i + record[i];
            }
        }

        int maxLen = 0;
        centerIdx = 0;
        for(int i = 1; i < n-1; i++) {
            if(record[i] > maxLen) {
                maxLen = record[i];
                centerIdx = i;
            }
        }

        return s.substring((centerIdx-1-maxLen)/2, (centerIdx-1-maxLen)/2+maxLen);
    }
}

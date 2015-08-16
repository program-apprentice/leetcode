package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 8/15/15
 * Time: 3:05 PM
 * Finished 3:43 PM
 */

import java.util.HashMap;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc",
 * which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.
 * */
public class LongestSubstringWithoutRepeatingCharacters_3 {
    public int lengthOfLongestSubstring_v1(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        int maxLength = 1;
        char cur;
        for(int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if(map.get(cur) != null) {
                maxLength = maxLength > (i - start) ? maxLength : (i - start);
                // remove middle chars
                int lastIdx = map.get(cur);
                for(int j = start; j <= lastIdx; j++) {
                    map.remove(s.charAt(j));
                }
                // reset start
                start = lastIdx + 1;
            } else {
                maxLength = maxLength > (i - start + 1) ? maxLength : i - start + 1;
            }
            map.put(cur, i);
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        boolean[] record = new boolean[256];
        char cur = 0;
        int max = 0;
        int start = 0;
        for(int i = 0; i < s.length(); i++) {
            cur = s.charAt(i);
            if(record[cur]) {
                while(s.charAt(start) != cur ) {
                    record[s.charAt(start)] = false;
                    start++;
                }
                start ++;
            } else {
                record[cur] = true;
            }
            max = max > (i - start + 1) ? max : i - start + 1;
        }
        return max;
    }
}
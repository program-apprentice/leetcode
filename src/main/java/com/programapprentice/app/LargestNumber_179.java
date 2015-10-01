package com.programapprentice.app;

import java.util.Arrays;
import java.util.Comparator;

/**
 * User: program-apprentice
 * Date: 9/30/15
 * Time: 7:41 PM
 */
public class LargestNumber_179 {
    public class Solution {
        private class StringComparator implements Comparator {
            // -1: o1 < o2; 1: o1 > o2
            public int compare(Object o1, Object o2) {
                String s1 = (String)o1;
                String s2 = (String)o2;
                String a = s1 + s2;
                String b = s2 + s1;
                int length = s1.length() + s2.length();
                for(int i = 0; i < length; i++) {
                    if(a.charAt(i) < b.charAt(i)) {
                        return 1;
                    } else if (a.charAt(i) > b.charAt(i)) {
                        return -1;
                    }
                }
                return 0;
            }

            public boolean equals(String s1, String s2) {
                return compare(s1, s2) == 0;
            }
        }

        public String largestNumber(int[] nums) {
            if(nums == null || nums.length == 0) {
                return null;
            }
            String[] strs = new String[nums.length];
            for(int i = 0; i < nums.length; i++) {
                strs[i] = Integer.toString(nums[i]);
            }
            Arrays.sort(strs, new StringComparator());
            StringBuilder sb = new StringBuilder();

            for(String str : strs) {
                sb.append(str);
            }
            String output = sb.toString();
            if(output.charAt(0) == '0') {
                return "0";
            }
            return output;
        }
    }
}

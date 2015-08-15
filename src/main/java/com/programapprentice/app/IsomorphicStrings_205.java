package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/14/15
 * Time: 10:26 PM
 */

import java.util.HashMap;

/**
 Given two strings s and t, determine if they are isomorphic.

 Two strings are isomorphic if the characters in s can be replaced to get t.

 All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

 For example,
 Given "egg", "add", return true.

 Given "foo", "bar", return false.

 Given "paper", "title", return true.

 Note:
 You may assume both s and t have the same length.
 * */
public class IsomorphicStrings_205 {
    public boolean isIsomorphic(String s, String t) {
        if(s == null && t == null) {
            return true;
        }
        if(s == null || t == null) {
            return false;
        }
        if(s.length() != t.length()) {
            return true;
        }
        HashMap<Character, Character> s2tmap = new HashMap<Character, Character>();
        HashMap<Character, Character> t2smap = new HashMap<Character, Character>();
        for(int i = 0; i < s.length(); i++) {
            if(!s2tmap.containsKey(s.charAt(i))) {
                if(t2smap.containsKey(t.charAt(i))) {
                    return false;
                } else {
                    s2tmap.put(s.charAt(i), t.charAt(i));
                    t2smap.put(t.charAt(i), s.charAt(i));
                }

            } else {
                char value = s2tmap.get(s.charAt(i));
                if(value != t.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}

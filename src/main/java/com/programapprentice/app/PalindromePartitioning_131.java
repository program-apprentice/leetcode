package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    // Begin start with 0.
    private boolean isPalindrome(String s, int begin, int end) {
        if(s == null || begin == end) {
            return true;
        }
        int low = begin;
        int high = end;
        while(low < high) {
            if(s.charAt(high) != s.charAt(low)) {
                return false;
            }
            low++;
            high--;
        }

        return true;
    }


    // This is unfinished
//    public List<List<String>> partitionUncomplete(String s) {
//        List<List<String>> output = new ArrayList<List<String>>();
//        boolean[][] isPalindrome = new boolean[][];
//
//        for(int i = 0; i < s.length(); i++) {
//
//        }
//
//        return output;
//    }

    //////////////////////////////////////////////////////////////////////
    // DFS accepted
    public List<List<String>> partitionDfs(String s) {
        List<List<String>> output = new ArrayList<List<String>>();

        for(int i = 0; i < s.length(); i++) {
            if(isPalindrome(s, 0, i)) { // wrong: if(isPalindrome(s, 0, i+1)) {
                if(i == s.length()-1) {
                    List<String> tmp = new ArrayList<String>();
                    tmp.add(s);
                    output.add(tmp);
                } else {
                    List<List<String>> tmp = partitionDfs(s.substring(i + 1));
                    for(List<String> item : tmp) {
                        item.add(0, s.substring(0, i+1));
                    }
                    output.addAll(tmp);
                }
            }
        }

        return output;
    }

}

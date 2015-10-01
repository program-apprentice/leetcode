package com.programapprentice.app;

/**
 * User: ruijiang
 * Date: 9/30/15
 * Time: 8:31 PM
 */
public class ReverseWordsInStringII_186 {
    public void reverse(char[] charArray, int begin, int end) {
        if(begin >= end) {
            return;
        }
        int low = begin;
        int high = end;
        char tmp;
        while(low < high) {
            tmp = charArray[low];
            charArray[low] = charArray[high];
            charArray[high] = tmp;
            low++;
            high--;
        }
    }

    public void reverseWords(char[] s) {
        if(s == null) {
            return;
        }
        reverse(s, 0, s.length-1);
        int start = 0;
        int end = 0;
        for(int i = start; i < s.length; i++) {
            if(s[i] == ' ') {
                end = i-1;
                reverse(s, start, end);
                start = i+1;
            }
        }
        end = s.length-1;
        reverse(s, start, end);
    }
}

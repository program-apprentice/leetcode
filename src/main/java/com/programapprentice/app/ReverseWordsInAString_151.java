package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 9/28/15
 * Time: 9:17 PM
 */
public class ReverseWordsInAString_151 {
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

    public String removeSpace(String s) {
        char[] charArray = s.toCharArray();
        int start = 1;
        int spaceCounter = 0;
        for(int i = 1; i < s.length(); i++) {
            if(charArray[i] == ' ') {
                if(spaceCounter == 0) {
                    spaceCounter++;
                    charArray[start] = charArray[i];
                    start++;
                } else {
                    spaceCounter++;
                }
            } else {
                spaceCounter = 0;
                charArray[start] = charArray[i];
                start++;
            }
        }
        return new String(charArray, 0, start);
    }

    public String reverseWords(String s) {
        s = s.trim();
        if(s.equals("")) {
            return s;
        }
        s = removeSpace(s);
        char[] charArray = s.toCharArray();
        reverse(charArray, 0, s.length()-1);
        int start = 0;
        int end = 0;
        for(int i = start; i < s.length(); i++) {
            if(charArray[i] == ' ') {
                end = i-1;
                reverse(charArray, start, end);
                start = i+1;
            }
        }
        end = s.length()-1;
        reverse(charArray, start, end);
        return new String(charArray);
    }
}

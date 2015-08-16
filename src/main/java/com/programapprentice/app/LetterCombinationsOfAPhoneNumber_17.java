package com.programapprentice.app;

import com.programapprentice.util.MainUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 12:48 PM
 */
public class LetterCombinationsOfAPhoneNumber_17 {
    public String map(char c) {
        String s = "";
        switch(c) {
            case '0':
                s = " ";
                break;
            case '1':
                s = "";
                break;
            case '2':
                s = "abc";
                break;
            case '3':
                s = "def";
                break;
            case '4':
                s = "ghi";
                break;
            case '5':
                s = "jkl";
                break;
            case '6':
                s = "mno";
                break;
            case '7':
                s = "pqrs";
                break;
            case '8':
                s = "tuv";
                break;
            case '9':
                s = "wxyz";
                break;
            default:
                break;
        }
        return s;
    }

    public List<String> letterCombinations(String digits) {
        List<String> output = new ArrayList<String>();
        if(digits == null || digits.length() == 0) {
            return output;
        }
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        for(int i = 0; i < digits.length(); i++) {
            if(list1.isEmpty()) {
                char[] cs = map(digits.charAt(i)).toCharArray();
                for(char c : cs) {
                    list1.add("" + c);
                }
            } else {
                for(String s : list1) {
                    char[] cs = map(digits.charAt(i)).toCharArray();
                    for(char c : cs) {
                        list2.add(s + c);
                    }
                }
                list1 = list2;
                list2 = new ArrayList<String>();
            }
        }
        return list1;
    }
}

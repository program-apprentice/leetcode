package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 10:08 PM
 */
/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 * */
public class CountAndSay_38 {
    public String countAndSay(int n) {
        if(n <= 0) {
            return "";
        }
        if(n == 1) {
            return "1";
        }
        String s = "11";
        int counter = 1;
        for(int i = 2; i < n; i++) {
            StringBuffer sb = new StringBuffer();
            counter = 1;
            char pre = s.charAt(0);
            char cur ;
            for(int j = 1; j < s.length(); j++) {
                cur = s.charAt(j);
                if(cur == pre) {
                    counter++;
                } else {
                    sb.append(counter);
                    sb.append(pre);
                    counter = 1;
                    pre = cur;
                }
            }
            sb.append(counter);
            sb.append(pre);
            s = sb.toString();
        }
        return s;
    }
}

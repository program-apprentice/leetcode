package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/6/15
 * Time: 10:30 PM
 */

import java.util.HashMap;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger_13 {

    public int romanToInt(String s) {
        if(s == null) {
            return 0;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char pre = s.charAt(s.length()-1);
        int result = map.get(pre);
        for(int i = s.length() - 2; i >= 0; i--) {
            if(map.get(s.charAt(i)) < map.get(pre)) {
                result -= map.get(s.charAt(i));
            } else {
                result += map.get(s.charAt(i));
            }
            pre = s.charAt(i);
        }
        return result;
    }
}

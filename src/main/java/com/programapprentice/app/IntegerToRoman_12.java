package com.programapprentice.app;

import java.util.HashMap;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 10:55 PM
 * Finished Time: 11:18 PM
 */
public class IntegerToRoman_12 {
    public String func1(HashMap<Integer, Character> map, int digit, int base) {
        if(digit == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if(digit == 9) {
            sb.append(map.get(base));
            sb.append(map.get(10 * base));
        } else if (digit == 4) {
            sb.append(map.get(base));
            sb.append(map.get(5 * base));
        } else {
            if(digit >= 5) {
                sb.append(map.get(5 * base));
                digit -= 5;
            }
            for(int i = 0; i < digit; i++) {
                sb.append(map.get(base));
            }
        }
        return sb.toString();
    }

    public String intToRoman(int num) {
        if(num <= 0) {
            return "";
        }
        HashMap<Integer, Character> map = new HashMap<Integer, Character>();
        map.put(1, 'I');
        map.put(5, 'V');
        map.put(10, 'X');
        map.put(50, 'L');
        map.put(100, 'C');
        map.put(500, 'D');
        map.put(1000, 'M');

        StringBuilder sb = new StringBuilder();
        int base = 1000;

        sb.append(func1(map, num/base, base));
        num = num % base;

        base = 100;
        sb.append(func1(map, num/base, base));
        num = num % base;

        base = 10;
        sb.append(func1(map, num/base, base));
        num = num % base;

        base = 1;
        sb.append(func1(map, num/base, base));

        return sb.toString();
    }
}

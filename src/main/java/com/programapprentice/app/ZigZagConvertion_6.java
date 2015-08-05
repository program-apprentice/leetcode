package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/4/15
 * Time: 9:18 PM
 */
public class ZigZagConvertion_6 {
    public String convert_v1(String s, int numRows) {
        if(s == null || numRows < 2) {
            return s;
        }

        char[] buffer = new char[s.length()];
        int bi = 0;
        int step = 2 * numRows - 2;
        for(int i = 1; i <= numRows; i++) {
            int cursor  = i - 1;
            if( 1 == i || numRows == i) {
                while(cursor < s.length()) {
                    buffer[bi] = s.charAt(cursor);
                    bi++;
                    cursor += step;
                }
            } else {
                int middleStep = 2 * (numRows - i);
                boolean isOdd = true;
                while(cursor < s.length()) {
                    buffer[bi] = s.charAt(cursor);
                    bi++;
                    if(isOdd) {
                        cursor += 2 * (numRows - i);
                    } else {
                        cursor += 2 * i - 2;
                    }
                    isOdd = !isOdd;
                }
            }
        }
        return new String(buffer);
    }

    public String convert(String s, int numRows) {
        if(s == null || numRows < 2) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int step = numRows + (numRows - 2);
        int midStep = step;
        int index = 0;
        for (int i = 1; i <= numRows; i++) {
            index = i - 1;
            if(i != 1 && i != numRows) {
                midStep -= 2;
            }
            while(index < s.length()) {
                sb.append(s.charAt(index));
                if(i != 1 && i != numRows) {
                    if(index + midStep < s.length()) {
                        sb.append(s.charAt(index + midStep));
                    }
                }
                index += step;
            }
        }
        return sb.toString();
    }
}

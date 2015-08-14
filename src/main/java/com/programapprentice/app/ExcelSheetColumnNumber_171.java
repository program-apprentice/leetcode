package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/13/15
 * Time: 6:48 PM
 * Finish Time: 6:55 PM
 */
public class ExcelSheetColumnNumber_171 {
    public int titleToNumber(String s) {
        if(s == null) {
            return 0;
        }
        int output = 0;
        for(int i = 0; i < s.length(); i++) {
            output = output * 26 + s.charAt(i) - 'A' + 1;
        }
        return output;
    }
}

package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/12/15
 * Time: 6:23 PM
 */
public class ValidPalindrome_125 {

    public boolean isAlphaNumeric(char c) {
        return (c <= '9' && c >= '0' ) || ( c <= 'z' && c >= 'a');
    }

    public boolean isPalindrome(String s) {
        if(s == null) {
            return false;
        }
        int high = s.length() - 1;
        int low = 0;
        s = s.toLowerCase();
        while(low < high) {
            char lowChar = s.charAt(low);
            char highChar = s.charAt(high);
            if(!isAlphaNumeric(lowChar)) {
                low++;
                continue;
            }
            if(!isAlphaNumeric(highChar)){
                high--;
                continue;
            }
            if(lowChar != highChar) {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
}

package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/8/15
 * Time: 10:27 PM
 */
/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 *
 * If the last word does not exist, return 0.
 *
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * For example,
 * Given s = "Hello World",
 * return 5.
 */
public class LengthOfLastWord_58 {
    /**
     * 1. empty string
     * 2. last word followed by space
     * 3. no space
     * */
    public int lengthOfLastWord(String s) {
        int result = 0;
        boolean metWord = false;
        for(int j = s.length() - 1; j >= 0; j--) {
            if(s.charAt(j) == ' ') {
                if(metWord) {
                    break;
                } else {
                    continue;
                }
            } else {
                metWord = true;
                result ++;
            }
        }
        return result;
    }
}

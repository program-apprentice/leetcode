package com.programapprentice.app;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

/**
 * User: ruijiang
 * Date: 8/15/15
 * Time: 3:37 PM
 */
public class LongestSubstringWithoutRepeatingCharacters_Test {
    LongestSubstringWithoutRepeatingCharacters_3 obj = new LongestSubstringWithoutRepeatingCharacters_3();
    @Test
    public void test1() {
        String s = "dvdf";
        int expected = 3;
        int actual = obj.lengthOfLongestSubstring(s);
        assertEquals(expected, actual);
    }
}

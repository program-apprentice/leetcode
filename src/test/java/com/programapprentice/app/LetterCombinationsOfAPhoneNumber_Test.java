package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 1:41 PM
 */
public class LetterCombinationsOfAPhoneNumber_Test {
    LetterCombinationsOfAPhoneNumber_17 obj = new LetterCombinationsOfAPhoneNumber_17();

    @Test
    public void test1() {
        String digits = "22";
        List<String> actual = obj.letterCombinations(digits);
        Util.printListString(actual);
    }
}

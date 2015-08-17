package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 6:20 PM
 */
public class GenerateParentheses_Test {
    GenerateParentheses_22 obj = new GenerateParentheses_22();
    @Test
    public void test1() {
        int n = 1;
        List<String> actual = obj.generateParenthesis(n);
        Util.printListString(actual);
    }
}

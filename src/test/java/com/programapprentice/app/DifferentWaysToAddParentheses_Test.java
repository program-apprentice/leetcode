package com.programapprentice.app;

import com.programapprentice.util.Util;
import org.junit.Test;

import java.util.List;

/**
 * User: program-apprentice
 * Date: 10/11/15
 * Time: 11:15 AM
 */
public class DifferentWaysToAddParentheses_Test {
    DifferentWaysToAddParentheses_241 obj = new DifferentWaysToAddParentheses_241();
    @Test
    public void test1() {
        String input = "2*3-4*5";
        List<Integer> actual = obj.diffWaysToCompute(input);
        Util.printListInteger(actual);
    }

    @Test
    public void test2() {
        String input = "2*3-4*5";
        List<String> tokens = obj.splitTokens(input);
        List<List<String>> afterParenteses = obj.insertParentheses(tokens);
        Util.printListOfListString(afterParenteses);
//        ( 2 * ( 3 - ( 4 * 5 ) ) )
//        ( 2 * ( ( 3 - 4 ) * 5 ) )
//        ( ( 2 * 3 ) - ( 4 * 5 ) )
//        ( ( 2 * ( 3 - 4 ) ) * 5 )
//        ( ( ( 2 * 3 ) - 4 ) * 5 )
    }

    @Test
    public void test3() {
        String input = "( ( ( 2 * 3 ) - 4 ) * 5 )";
        List<String> tokens = obj.splitTokens(input);
        List<String> result = obj.toRPN(tokens);
        Util.printListToken(result);
    }

}

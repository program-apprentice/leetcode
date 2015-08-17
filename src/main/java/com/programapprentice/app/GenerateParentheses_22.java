package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 3:13 PM
 */
public class GenerateParentheses_22 {
    public void rec(int n, int left, int right, String s, List<String> list) {
        if(right > left) {
            return;
        }
        if(left == n && right == n) {
            list.add(s);
            return;
        }
        if(left < n) {
            rec(n, left + 1, right, s + "(", list);
        }
        if(right < n && right < left) {
            rec(n, left, right + 1, s + ")", list);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<String>();
        if(n == 0) {
            return output;
        }

        rec(n, 0, 0, "", output);
        return output;

    }
}

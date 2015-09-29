package com.programapprentice.app;

import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 9/28/15
 * Time: 9:15 PM
 */
public class EvaluateReversePolishNotation_150 {
    public int evalRPN(String[] tokens) {
        if(tokens == null) {
            return 0;
        }
        Stack<Integer> stack = new Stack<Integer>();
        int first = 0;
        int second = 0;
        for(String token : tokens) {
            if(token.equals("+")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first + second);
            } else if (token.equals("-")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first - second);
            } else if (token.equals("*")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first * second);
            } else if (token.equals("/")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first / second);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        if(stack.isEmpty()) {
            return 0;
        }
        return stack.pop();
    }
}

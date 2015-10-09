package com.programapprentice.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 10/8/15
 * Time: 9:00 PM
 */
public class BasicCalculator_224 {
    /**
     * https://en.wikipedia.org/wiki/Shunting-yard_algorithm
     * */
    /**
     * if the token is a number, then add it to the output queue
     * if the token is operator o1, then:
     *     while there is an operator at the top of stack, and not '('
     *         pop o2 into output queue
     *     push o1 to stack
     * if token is '(', push to stack
     * if token is ')'
     *     until the token at the top of the stack is '(', pop operator to the queue
     *     pop '('
     * when there is no more token to read
     *     while there are still operator tokens in the stack
     *         pop the operator into the queue
     * */
    private boolean isOperator(String token) {
        if(token.length() == 1) {
            char c = token.charAt(0);
            if(c == '-' || c == '+' || c == '(' || c == ')') {
                return true;
            }
        }
        return false;
    }

    private List<String> toRPN(List<String> infix) {
        Stack<String> stack = new Stack<String>();
        List<String> rpn = new ArrayList<String>();
        for(String token : infix) {
            if(!isOperator(token)) {
                rpn.add(token);
            } else {
                if(token.equals("(")) {
                    stack.push(token);
                } else if (token.equals(")")) {
                    while(!stack.isEmpty() && !stack.peek().equals("(")) {
                        rpn.add(stack.pop());
                    }
                    stack.pop();
                } else {
                    while(!stack.isEmpty() && !stack.peek().equals("(")) {
                        rpn.add(stack.pop());
                    }
                    stack.push(token);
                }
            }
        }
        while(!stack.isEmpty()) {
            rpn.add(stack.pop());
        }
        return rpn;
    }

    private List<String> removeSpace(String s) {
        List<String> tokens = new ArrayList<String>();
        int start = 0;
        boolean isPreviousNumber = false;
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c >= '0' && c <= '9') {
                if(!isPreviousNumber) {
                    start = i;
                    isPreviousNumber = true;
                }
            } else {
                if(isPreviousNumber) {
                    tokens.add(s.substring(start, i));
                    isPreviousNumber = false;
                }
                if(c != ' ') {
                    tokens.add(s.substring(i, i+1));
                }
            }
        }
        if(isPreviousNumber) {
            tokens.add(s.substring(start));
        }
        return tokens;
    }

    private int evalRPN(List<String> tokens) {
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
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        if(stack.isEmpty()) {
            return 0;
        }
        return stack.pop();
    }

    public int calculate(String s) {
        if(s == null) {
            return 0;
        }
        List<String> tokens = removeSpace(s);
        List<String> rpn = toRPN(tokens);
        return evalRPN(rpn);
    }
}

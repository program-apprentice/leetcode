package com.programapprentice.app;

import com.programapprentice.util.MainUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 10/10/15
 * Time: 8:20 PM
 */
public class DifferentWaysToAddParentheses_241 {

    private boolean isOperator(String token) {
        if(token.length() == 1) {
            char c = token.charAt(0);
            if(c == '-' || c == '+' || c == '*' || c == '(' || c == ')') {
                return true;
            }
        }
        return false;
    }

    public List<String> toRPN(List<String> infix) {
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
                } else if(token.equals("*")) {
                    while(!stack.isEmpty() && !stack.peek().equals("(")) {
                        String top = stack.peek();
                        if(top.equals("*")) {
                            rpn.add(stack.pop());
                        } else {
                            break;
                        }
                    }
                    stack.push(token);
                } else if (token.equals("+") || token.equals("-")) {
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

    public List<List<String>> insertParentheses(List<String> input) {
        List<List<String>> output = new ArrayList<List<String>>();
        if(input.size() < 3) {
            List<String> newItem = new ArrayList<String>();
            newItem.addAll(input);
            output.add(newItem);
            return output;
        }
        if(input.size() == 3) {
            List<String> newItem = new ArrayList<String>();
            newItem.addAll(input);
            newItem.add(")");
            newItem.add(0, "(");
            output.add(newItem);
            return output;
        }
        int n = input.size();
        int i = 1;
        while(i < input.size()) {
            List<List<String>> left = insertParentheses(input.subList(0, i));
            List<List<String>> right = insertParentheses(input.subList(i+1, input.size()));
            for(List<String> lItem : left) {
                for(List<String> rItem : right) {
                    List<String> newItem = new ArrayList<String>();
                    newItem.addAll(lItem);
                    newItem.add(0, "(");
                    newItem.add(input.get(i));
                    newItem.addAll(rItem);
                    newItem.add(")");
                    output.add(newItem);
                }
            }
            i += 2;
        }
        return output;
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
            } else if (token.equals("*")) {
                second = stack.pop();
                first = stack.pop();
                stack.push(first * second);
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        if(stack.isEmpty()) {
            return 0;
        }
        return stack.pop();
    }

    public List<String> splitTokens(String s) {
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

    public List<Integer> diffWaysToCompute(String input) {
        List<String> tokens = splitTokens(input);
        List<List<String>> afterParenthesis = insertParentheses(tokens);
        List<Integer> output = new ArrayList<Integer>();

        for(List<String> item : afterParenthesis) {
            List<String> rpn = toRPN(item);
            output.add(evalRPN(rpn));
        }
        Collections.sort(output);
        return output;
    }
}

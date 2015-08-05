package com.programapprentice.app;

/**
 * User: program apprentice
 * Date: 8/4/15
 * Time: 3:06 PM
 */

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * */
public class ValidParentheses_20 {
    public boolean isValid_v1(String s) {
        if(s == null) {
            return true;
        }
        /**
         * Create a new stack.
         * if char is { ( [, put it in stack, otherwise, pop from stack.
         * 3 conditions when it is invalid
         * 1. char is ], stack top is not [
         * 2. char is ), stack top is not (
         * 3. char is }, stack top is not {
         * */

        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i ++) {
            char c = s.charAt(i);
            switch(c) {
                case '(':
                    stack.push(c);
                    break;
                case '[':
                    stack.push(c);
                    break;
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if(!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case ']':
                    if(!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                case '}':
                    if(!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
     }

    public boolean isValid_v2(String s) {
        if(s == null) {
            return true;
        }
        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            } else {
                if(!stack.empty() && map.get(stack.pop()) == s.charAt(i)) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        return stack.empty();
    }

    public boolean isValid(String s) {
        if(s == null) {
            return true;
        }

        HashMap<Character, Character> map = new HashMap<Character, Character>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');

        Stack<Character> stack = new Stack<Character>();

        for(Character c : s.toCharArray()) {
            if(map.containsKey(c)) {
                stack.push(c);
            } else {
                if(stack.empty() || map.get(stack.pop()) != c) {
                    return false;
                }
            }
        }

        return stack.empty();
    }
}

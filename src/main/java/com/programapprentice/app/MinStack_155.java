package com.programapprentice.app;

import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 8/12/15
 * Time: 6:36 PM
 */
public class MinStack_155 {
    Stack<Integer> stack  = new Stack<Integer>();
    Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || x <= minStack.peek()) {
            minStack.push(x);
        }
    }

    public void pop() {
        if(stack.isEmpty()) {
           return;
        }
        if(stack.peek().intValue() == minStack.peek().intValue()) {
            minStack.pop();
        }
        stack.pop();

    }

    public int top() {
        if(stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
       return minStack.peek();
    }
}

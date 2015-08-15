package com.programapprentice.app;

import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 12:51 PM
 */
public class ImplementQueueUsingStacks_232 {
    Stack<Integer> s1 = new Stack<Integer>();
    Stack<Integer> s2 = new Stack<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        // move from s1 to s2
        while(!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        s2.push(x);
        while(!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(s1.isEmpty()) {
            return;
        }
        s1.pop();
    }

    // Get the front element.
    public int peek() {
        if(s1.isEmpty()) {
            return 0;
        }
        return s1.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty();
    }
}

package com.programapprentice.app;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: program-apprentice
 * Date: 8/14/15
 * Time: 11:23 PM
 */
public class ImplementStackUsingQueues_225 {
    Queue<Integer> queue1 = new LinkedList<Integer>();
    Queue<Integer> queue2 = new LinkedList<Integer>();

    // Push element x onto stack.
    public void push(int x) {
        queue1.add(x);
        if(!queue2.isEmpty()) {
            while(!queue2.isEmpty()) {
                queue1.add(queue2.remove());
            }
        }
        Queue tmp = queue1;
        queue1 = queue2;
        queue2 = tmp;
    }

    // Removes the element on top of the stack.
    public void pop() {
        queue2.remove();
    }

    // Get the top element.
    public int top() {
        return queue2.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue2.isEmpty();
    }
}

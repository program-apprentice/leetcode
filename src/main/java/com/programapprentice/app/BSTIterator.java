package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 9/30/15
 * Time: 7:43 PM
 */
public class BSTIterator {
    private Stack<TreeNode> stack = new Stack<TreeNode>();

    private void pushLeftNodes(TreeNode root) {
        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
    }
    public BSTIterator(TreeNode root) {
        pushLeftNodes(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int result = node.val;
        pushLeftNodes(node.right);
        return result;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
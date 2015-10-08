package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 10/7/15
 * Time: 9:01 PM
 */
public class KthSmallestElementInABST_230 {
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        int counter = 0;
        push(root, stack);
        while(!stack.isEmpty()) {
            TreeNode p = stack.pop();
            counter++;
            if(counter == k) {
                return p.val;
            }
            push(p.right, stack);
        }
        return -1;
    }

    public void push(TreeNode root, Stack<TreeNode> stack) {
        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
    }
}

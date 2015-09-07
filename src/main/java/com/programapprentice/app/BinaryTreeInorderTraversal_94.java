package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 9/6/15
 * Time: 11:22 PM
 * Finished Time: 11:40 PM
 */
public class BinaryTreeInorderTraversal_94 {
    public void pushStack(Stack<TreeNode> stack, TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode p = root;
        while(p != null) {
            stack.push(p);
            p = p.left;
        }
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        pushStack(stack, root);
        TreeNode top = null;
        while(!stack.isEmpty()) {
            top = stack.pop();
            output.add(top.val);
            if(top.right != null) {
                pushStack(stack, top.right);
            }
        }
        return output;
    }
}

package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 9/29/15
 * Time: 8:51 PM
 */
public class BinaryTreeUpsideDown_156 {
    private void convertTree(TreeNode root, TreeNode right) {
        if(root == null) {
            return;
        }
        // left is always exist.
        TreeNode nextRight = root.right;
        root.right = right;
        convertTree(root.left, nextRight);
    }

    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        // 1. Convert the tree shape
        convertTree(root, null);
        // 2. Reverse the tree
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode t = root;
        while(t != null) {
            stack.push(t);
            t = t.left;
        }
        TreeNode newRoot = stack.pop();
        newRoot.left = newRoot.right;
        t = newRoot;
        while(!stack.isEmpty()) {
            t.right = stack.pop();
            t = t.right;
            t.left = t.right;
        }
        return newRoot;
    }
}

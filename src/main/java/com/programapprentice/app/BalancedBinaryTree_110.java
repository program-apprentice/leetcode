package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

/**
 * User: program-apprentice
 * Date: 8/10/15
 * Time: 10:17 PM
 */
public class BalancedBinaryTree_110 {
    public int depth(TreeNode root) {
        if(root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if(root == null) {
            return true;
        }
        int lDepth = depth(root.left);
        int rDepth = depth(root.right);
        if(isBalanced(root.left) && isBalanced(root.right)) {
            return Math.abs(lDepth-rDepth) <= 1;
        }
        return false;
    }
}

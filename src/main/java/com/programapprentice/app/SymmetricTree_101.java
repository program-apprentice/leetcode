package com.programapprentice.app;

/**
 * User: program-apprentice
 * Date: 8/9/15
 * Time: 12:19 PM
 */

import com.programapprentice.util.TreeNode;

/**
 * Given a binary tree, check whether it is a mirror of itself
 * (ie, symmetric around its center).
 */

public class SymmetricTree_101 {
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if(left == null && right == null) {
            return true;
        }
        if(left == null || right == null) {
            return false;
        }
        if(left.val != right.val) {
            return false;
        }
        return isSymmetric(left.right, right.left) && isSymmetric(left.left, right.right);
    }

    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return isSymmetric(root.left, root.right);
    }
}

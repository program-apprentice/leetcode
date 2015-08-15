package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 12:05 AM
 * Finished Time: 12:07 AM
 */
public class InvertBinaryTree_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        root.left = invertTree(root.left);
        root.right = invertTree(root.right);
        return root;
    }
}

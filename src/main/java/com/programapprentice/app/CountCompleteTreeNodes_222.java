package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

/**
 * User: program-apprentice
 * Date: 10/6/15
 * Time: 9:44 PM
 */
public class CountCompleteTreeNodes_222 {
    public int countNodes(TreeNode root) {
        if(root == null) {
            return 0;
        }
        TreeNode left = root.left;
        int lDepth = 0;
        while(left != null) {
            left = left.left;
            lDepth++;
        }
        TreeNode right = root.right;
        int rDepth = 0;
        while(right != null) {
            right = right.right;
            rDepth++;
        }

        if(lDepth == rDepth) {
            return (1 << (lDepth+1)) - 1;
        }
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}

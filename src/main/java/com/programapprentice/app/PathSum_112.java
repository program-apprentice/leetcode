package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

/**
 * User: program-apprentice
 * Date: 8/11/15
 * Time: 9:11 PM
 */
public class PathSum_112 {
    public boolean hasPathSum_v1(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return sum == root.val;
        }
        if(root.left != null && root.right != null) {
            return hasPathSum_v1(root.left, sum - root.val) || hasPathSum_v1(root.right, sum - root.val);
        }
        if(root.left != null && root.right == null) {
            return hasPathSum_v1(root.left, sum - root.val);
        }
        if(root.left == null && root.right != null) {
            return hasPathSum_v1(root.right, sum - root.val);
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        if(root.left == null && root.right == null) {
            return sum == root.val;
        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}

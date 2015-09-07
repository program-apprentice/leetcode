package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

/**
 * User: program-apprentice
 * Date: 9/7/15
 * Time: 2:06 PM
 */
public class ValidateBinarySearchTree_98 {
    public boolean isValidBST(TreeNode root) {
        return isValidTree(root, null, null);
    }

    public boolean isValidTree(TreeNode root, Integer low, Integer high) {
        if(root == null) {
            return true;
        }
        if((low != null && root.val <= low) || (high != null && root.val >= high)) {
        // wrong:  if((low != null && root.val < low) || (high != null && root.val > high)) {
            return false;
        }
        boolean isLeftValid = isValidTree(root.left, low , root.val );
        boolean isRightValid = isValidTree(root.right, root.val, high);
        return isLeftValid && isRightValid;
    }
}

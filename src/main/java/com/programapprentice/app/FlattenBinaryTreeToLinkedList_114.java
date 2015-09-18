package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

/**
 * User: program-apprentice
 * Date: 9/7/15
 * Time: 8:33 PM
 */
public class FlattenBinaryTreeToLinkedList_114 {
    // Recursive is too slow
    public void flatten_v1(TreeNode root) {
        if(root == null) {
            return;
        }
        flatten_v1(root.left);
        TreeNode p = root.left;
        if(p != null) {
            while (p.right != null) {
                p = p.right;
            }
            flatten_v1(root.right);
            p.right = root.right;
            root.right = root.left;
        }
    }

    public void flatten(TreeNode root) {
        flatten2(root);
    }
    // return last node in flatten
    public TreeNode flatten2(TreeNode root) {
        if(root == null) {
            return root; // wrong: return null
        }
        if(root.left == null && root.right == null) {
            return root;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode leftLast = flatten2(left);
        if(leftLast != null) {
            root.left = null; // missing this one.
            root.right = left; // wrong: root.left = left
            leftLast.right = right;
        }
        TreeNode rightLast = flatten2(right);
        if(rightLast != null) {
            return rightLast;
        }
        return leftLast;
    }
}

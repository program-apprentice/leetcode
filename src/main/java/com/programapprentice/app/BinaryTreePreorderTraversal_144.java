package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/27/15
 * Time: 10:25 PM
 * Finished Time: 10:29 PM
 */
public class BinaryTreePreorderTraversal_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
        output.add(root.val); // missing this one.
        List<Integer> left = preorderTraversal(root.left);
        output.addAll(left);
        List<Integer> right = preorderTraversal(root.right);
        output.addAll(right);
        return output;
    }
}

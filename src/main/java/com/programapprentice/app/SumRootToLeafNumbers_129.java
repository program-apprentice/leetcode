package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: program-apprentice
 * Date: 9/9/15
 * Time: 5:57 PM
 */
public class SumRootToLeafNumbers_129 {
    public boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right==null;
    }

    public int sumNumbers(TreeNode root) {
        if(root == null) {
            return 0; // missing this section
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int sum = 0;
        TreeNode node = null;
        while(!queue.isEmpty()) {
            node = queue.remove();
            if(isLeaf(node)) {
                sum += node.val;
            }
            if(node.left != null) {
                node.left.val = node.left.val + node.val * 10; // wrong: node.left.val = node.left.val + root.val * 10;
                queue.add(node.left);
            }
            if(node.right != null) {
                node.right.val = node.right.val + node.val * 10; // node.right.val = node.right.val + root.val * 10;
                queue.add(node.right);
            }
        }
        return sum;
    }
}

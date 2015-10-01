package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: ruijiang
 * Date: 9/30/15
 * Time: 8:43 PM
 */
public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> output = new ArrayList<Integer>();
        if(root == null) {
            return output;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            TreeNode node = queue.remove();
            if(node == null) {
                continue;
            }
            if(node.left != null) {
                queue.add(node.left);
            }
            if(node.right != null) {
                queue.add(node.right);
            }
            if(queue.peek() == null) {
                queue.add(null);
                output.add(node.val);
            }
        }
        return output;
    }
}

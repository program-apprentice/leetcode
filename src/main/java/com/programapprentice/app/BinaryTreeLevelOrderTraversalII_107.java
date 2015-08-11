package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: program-apprentice
 * Date: 8/10/15
 * Time: 6:04 PM
 */
public class BinaryTreeLevelOrderTraversalII_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(null == root) {
            return output;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        List<Integer> tmp = new ArrayList<Integer>();
        TreeNode cur = null;
        boolean newLine = false;
        while(!queue.isEmpty()) {
            cur = queue.remove();
            if(cur == null) {
                tmp = new ArrayList<Integer>();
                continue;
            }
            tmp.add(cur.val);
            if(queue.peek() == null) {
                newLine = true;
                output.add(0, tmp);
            } else {
                newLine = false;
            }
            if(cur.left != null) {
                queue.add(cur.left);
            }
            if(cur.right != null) {
                queue.add(cur.right);
            }
            if(newLine) {
                queue.add(null);
            }
        }
        if(!tmp.isEmpty()) {
            output.add(tmp);
        }
        return output;
    }
}

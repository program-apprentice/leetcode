package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * User: program-apprentice
 * Date: 8/9/15
 * Time: 12:56 PM
 */
/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal_102 {
    public List<List<Integer>> levelOrderOneQueue(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null) {
            return output;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        Queue<Integer> level = new LinkedList<Integer>();
        queue.add(root);
        level.add(1);
        int preLevel = 0;
        int curLevel = 0;
        TreeNode curNode = null;
        List<Integer> tmpList = null;
        while(!queue.isEmpty()) {
            curLevel = level.remove();
            if(curLevel != preLevel) {
                if(preLevel != 0) {
                    output.add(tmpList);
                }
                tmpList = new ArrayList<Integer>();
            }
            curNode = queue.remove();
            tmpList.add(curNode.val);
            if(curNode.left != null) {
                queue.add(curNode.left);
                level.add(curLevel+1);
            }
            if(curNode.right != null) {
                queue.add(curNode.right);
                level.add(curLevel+1);
            }
            preLevel = curLevel;
        }
        if(!tmpList.isEmpty()) {
            output.add(tmpList);
        }
        return output;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null) {
            return output;
        }
        Queue<TreeNode> oddQueue = new LinkedList<TreeNode>();
        Queue<TreeNode> evenQueue = new LinkedList<TreeNode>();
        oddQueue.add(root);

        TreeNode curNode = null;
        List<Integer> tmpList = new ArrayList<Integer>();
        boolean isOddLevel = true;
        Queue<TreeNode> curQueue = null;
        Queue<TreeNode> otherQueue = null;
        while(!oddQueue.isEmpty() || !evenQueue.isEmpty()) {
            if(isOddLevel) {
                curQueue = oddQueue;
                otherQueue = evenQueue;
            } else {
                curQueue = evenQueue;
                otherQueue = oddQueue;
            }
            curNode = curQueue.remove();
            tmpList.add(curNode.val);
            if(curQueue.isEmpty()) {
                isOddLevel = !isOddLevel;
                output.add(tmpList);
                tmpList = new ArrayList<Integer>();
            }
            if(curNode.left != null) {
                otherQueue.add(curNode.left);
            }
            if(curNode.right != null) {
                otherQueue.add(curNode.right);
            }
        }
        if(!tmpList.isEmpty()) {
            output.add(tmpList);
        }
        return output;
    }
}

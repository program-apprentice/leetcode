package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * User: program-apprentice
 * Date: 9/7/15
 * Time: 2:26 PM
 */
/**
 * Two solutions:
 * 1 Use level traversal, than reverse the list for even level
 * 2. Use two stacks
 * */

public class BinaryTreeZipzagLevelOrderTraversal_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> oddStack = new Stack<TreeNode>();
        Stack<TreeNode> evenStack = new Stack<TreeNode>();
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null) { // missing this part
            return output;
        }
        boolean isOdd = true;
        oddStack.push(root);
        List<Integer> item = new ArrayList<Integer>();
        TreeNode top = null;
        while(!oddStack.isEmpty() || !evenStack.isEmpty()) {
        // wrong: while(!oddStack.isEmpty() && !evenStack.isEmpty()) {
            if(isOdd) {
                top = oddStack.pop();
                item.add(top.val);
                if(oddStack.isEmpty()) {
                    isOdd = false;
                    output.add(item);
                    item = new ArrayList<Integer>();
                }
                if(top.left != null) {
                    evenStack.push(top.left);
                }
                if(top.right != null) {
                    evenStack.push(top.right);
                }
            } else {
                top = evenStack.pop();
                item.add(top.val);
                if(evenStack.isEmpty()) {
                    isOdd = true;
                    output.add(item);
                    item = new ArrayList<Integer>();
                }
                if(top.right != null) {
                    oddStack.push(top.right);
                }
                if(top.left != null) {
                    oddStack.push(top.left);
                }
            }
        }
        return output;
    }
}

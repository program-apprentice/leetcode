package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: program-apprentice
 * Date: 9/7/15
 * Time: 3:20 PM
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || inorder.length ==  0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < postorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(postorder, postorder.length-1, 0, postorder.length-1, map);
    }

    public TreeNode buildTree(int[] postorder, int curIdx, int start, int end, Map<Integer, Integer> map ) {
        TreeNode root = new TreeNode(postorder[curIdx]);
        if(start < end) {
            int mid = map.get(postorder[curIdx]);
            if(mid > start) {
                root.left = buildTree(postorder, curIdx - (end - mid) - 1 , start, mid-1, map);
            }
            if(mid < end) {
                root.right = buildTree(postorder, curIdx - 1, mid + 1, end, map);
            }
        }
        return root;
    }
}

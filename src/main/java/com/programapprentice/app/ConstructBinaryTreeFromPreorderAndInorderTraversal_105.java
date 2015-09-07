package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * User: program-apprentice
 * Date: 9/7/15
 * Time: 2:51 PM
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length ==  0) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTree(preorder, 0, 0, preorder.length-1, map);
    }

    public TreeNode buildTree(int[] preorder, int curIdx, int start, int end, Map<Integer, Integer> map ) {
        TreeNode root = new TreeNode(preorder[curIdx]);
        if(start < end) {
            int mid = map.get(preorder[curIdx]);
            if(mid > start) {
                root.left = buildTree(preorder, curIdx + 1, start, mid-1, map);
            }
            if(mid < end) {
                root.right = buildTree(preorder, curIdx + mid - start + 1, mid + 1, end, map);
            }
        }
        return root;
    }
}

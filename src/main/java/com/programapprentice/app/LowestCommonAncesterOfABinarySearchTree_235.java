package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 1:49 PM
 * Finished Time: 2:26 PM
 */
public class LowestCommonAncesterOfABinarySearchTree_235 {
    /**
    * 1. find ancesters for both p and q
    * 2. find LCA
    */
    public List<TreeNode> getAncesters(TreeNode root, TreeNode p) {
        List<TreeNode> output = new ArrayList<TreeNode>();
        TreeNode t = root;
        while(t != null) {
            output.add(t);
            if(t.val == p.val) {
                return output;
            }
            if(t.val < p.val) {
                t = t.right;
            } else {
                t = t.left;
            }
        }
        return new ArrayList<TreeNode>(); // p is not in tree root
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        List<TreeNode> pAncesters = getAncesters(root, p);
        List<TreeNode> qAncesters = getAncesters(root, q);
        int num = Math.min(pAncesters.size(), qAncesters.size());
        TreeNode lca = null;
        TreeNode pa, qa;
        for(int i = 0 ; i < num; i++) {
            if(pAncesters.get(i) == qAncesters.get(i)) {
                lca = pAncesters.get(i);
            } else {
                break;
            }
        }
        return lca;
    }
}

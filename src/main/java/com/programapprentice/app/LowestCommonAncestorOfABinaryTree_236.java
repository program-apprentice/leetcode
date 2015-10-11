package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 10/10/15
 * Time: 6:35 PM
 */
public class LowestCommonAncestorOfABinaryTree_236 {
    public List<TreeNode> getAncestors(TreeNode root, TreeNode p) {
        List<TreeNode> nodes = new ArrayList<TreeNode>();
        if(root == null) {
            return nodes;
        }
        List<Integer> status = new ArrayList<Integer>();

        nodes.add(root);
        status.add(1); // 1: left 2: right 3: root

        while(!nodes.isEmpty()) {
            TreeNode top = nodes.get(nodes.size()-1);
            if(top == p) {
                break;
            }
            int state = status.get(status.size()-1);
            if(state == 1) {
                status.set(status.size()-1, 2);
                if(top.left != null) {
                    nodes.add(top.left);
                    status.add(1);
                }
            } else if (state == 2) {
                status.set(status.size()-1, 3);
                if(top.right != null) {
                    nodes.add(top.right);
                    status.add(1);
                }
            } else if (state == 3) {
                nodes.remove(nodes.size()-1);
                status.remove(status.size()-1);
            }
        }

        return nodes;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pAncesters = getAncestors(root, p);
        List<TreeNode> qAncesters = getAncestors(root, q);
        int n = Math.min(pAncesters.size(), qAncesters.size());
        TreeNode output = null;
        for(int i = 0; i < n; i++) {
            if(pAncesters.get(i).val != qAncesters.get(i).val) {
                break;
            }
            output = pAncesters.get(i);
        }
        return output;
    }
}

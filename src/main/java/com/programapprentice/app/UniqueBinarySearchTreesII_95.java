package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/7/15
 * Time: 1:54 PM
 */
public class UniqueBinarySearchTreesII_95 {
    public List<TreeNode> generateTrees(int n) {
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> output = new ArrayList<TreeNode>();
        if(start > end) {
            output.add(null);
            return output;
        }

        for(int i = start; i <= end; i++) {
            List<TreeNode> leftSubTrees = generateTrees(start, i-1);
            List<TreeNode> rightSubTrees = generateTrees(i+1, end);
            for(TreeNode left : leftSubTrees) {
                for(TreeNode right : rightSubTrees) {
                    TreeNode node = new TreeNode(i);
                    node.left = left;
                    node.right = right;
                    output.add(node);
                }
            }
        }
        return output;
    }
}

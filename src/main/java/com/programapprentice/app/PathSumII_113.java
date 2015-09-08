package com.programapprentice.app;

import com.programapprentice.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * User: program-apprentice
 * Date: 9/7/15
 * Time: 6:14 PM
 * Finished Time: 6:22 PM
 */
public class PathSumII_113 {
    public boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> output = new ArrayList<List<Integer>>();
        if(root == null) {
            return output;
        }
        if(isLeaf(root)) {
            if(root.val == sum) {
                List<Integer> result = new ArrayList<Integer>();
                result.add(root.val);
                output.add(result);
            }
            return output;
        }
        List<List<Integer>> leftResult = pathSum(root.left, sum - root.val);
        for(List<Integer> item : leftResult) {
            item.add(0, root.val);
            output.add(item);
        }
        List<List<Integer>> rightResult = pathSum(root.right, sum - root.val);
        for(List<Integer> item : rightResult) {
            item.add(0, root.val);
            output.add(item);
        }
        return output;
    }
}

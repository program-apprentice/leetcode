package com.programapprentice.app;

import com.programapprentice.util.TreeNode;
import org.junit.Test;

/**
 * User: program-apprentice
 * Date: 9/29/15
 * Time: 9:04 PM
 */
public class BinaryTreeUpsideDown_Test {
    BinaryTreeUpsideDown_156 obj = new BinaryTreeUpsideDown_156();

    @Test
    public void test1() {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(3);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.left.left = new TreeNode(4);
        TreeNode newRoot = obj.upsideDownBinaryTree(root);
    }
}

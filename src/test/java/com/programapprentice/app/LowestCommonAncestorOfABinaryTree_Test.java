package com.programapprentice.app;

import com.programapprentice.util.TreeNode;
import org.junit.Test;

/**
 * User: program-apprentice
 * Date: 10/10/15
 * Time: 7:41 PM
 */
public class LowestCommonAncestorOfABinaryTree_Test {
    LowestCommonAncestorOfABinaryTree_236 obj = new LowestCommonAncestorOfABinaryTree_236();
    @Test
    public void test1() {
        /*
        _______3______
       /              \
    ___5__          ___1__
   /      \        /      \
   6      _2       0       8
         /  \
         7   4
        * */
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode ancestor = obj.lowestCommonAncestor(root, root.left.left, root.right.right);
        System.out.println(ancestor.val);

        ancestor = obj.lowestCommonAncestor(root, root.left.left, root.left.right.left);
        System.out.println(ancestor.val);

        ancestor = obj.lowestCommonAncestor(root, root.left, root.left.right.left);
        System.out.println(ancestor.val);

        ancestor = obj.lowestCommonAncestor(root, root.right, root.right.right);
        System.out.println(ancestor.val);
    }
}

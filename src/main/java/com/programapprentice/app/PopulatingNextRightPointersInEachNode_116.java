package com.programapprentice.app;

import com.programapprentice.util.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * User: program-apprentice
 * Date: 9/8/15
 * Time: 9:56 PM
 */
public class PopulatingNextRightPointersInEachNode_116 {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<TreeLinkNode>();
        queue.add(root);
        queue.add(null);
        TreeLinkNode head = null;
        TreeLinkNode next = null;
        while(!queue.isEmpty()) {
            head = queue.remove();

            if(head == null) {
                continue;
            }
            next = queue.peek();
            head.next = next;
            if(head.left != null) {
                queue.add(head.left);
            }
            if(head.right != null) {
                queue.add(head.right);
            }
            if(next == null) {
                queue.add(null);
            }
        }
    }
}

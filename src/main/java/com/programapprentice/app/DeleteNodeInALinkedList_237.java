package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 1:07 PM
 */
public class DeleteNodeInALinkedList_237 {
    public void deleteNode(ListNode node) {
        if(node.next == null) {
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

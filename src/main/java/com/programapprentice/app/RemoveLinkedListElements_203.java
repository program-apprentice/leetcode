package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/14/15
 * Time: 10:19 PM
 */
public class RemoveLinkedListElements_203 {
    // Remove all elements from a linked list of integers that have value val.
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) {
            return head;
        }
        ListNode tHead = new ListNode(0);
        tHead.next = head;
        ListNode p = head;
        ListNode r = tHead;
        while(p != null) {
            if(p.val == val) {
                r.next = p.next;
            } else {
                r = p;
            }
            p = p.next;
        }
        return tHead.next;
    }
}

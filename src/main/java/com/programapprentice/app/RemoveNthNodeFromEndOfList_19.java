package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/7/15
 * Time: 11:29 PM
 */
/**
 * Given a linked list, remove the nth node from the end of list and return its head.
 * For example,
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * */

public class RemoveNthNodeFromEndOfList_19 {
    /**
     * 1 if N > length, no node will be removed.
     * 2 removing head node0
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        if(0 == n) {
            return head;
        }
        ListNode q = head;
        ListNode p = head;
        int i = 0;
        for(; i < n && q != null; i++) {
            q = q.next;
        }
        if(q == null) {
            if(i < n) {
                return head;// no deletion
            } else if (i == n) {
                return head.next; // delete head
            }
        }
        while(q.next != null) {
            p = p.next;
            q = q.next;
        }
        p.next = p.next.next;
        return head;
    }
}

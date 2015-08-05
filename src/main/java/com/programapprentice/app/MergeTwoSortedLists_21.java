package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/4/15
 * Time: 7:52 PM
 */

/**
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * */
public class MergeTwoSortedLists_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        /**
         * 1. Create a new node for new
         * */
        ListNode newHead = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode r = newHead;
        while(p != null && q != null) {
            if(p.val > q.val) {
                r.next = q;
                q = q.next;
            } else {
                r.next = p;
                p = p.next;
            }
            r = r.next;
        }
        if(p == null) {
            r.next = q;
        } else {
            r.next = p;
        }
        newHead = newHead.next;
        return newHead;
    }
}

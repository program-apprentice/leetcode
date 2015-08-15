package com.programapprentice.app;

import com.programapprentice.util.ListNode;

// Reverse a singly linked list.

/**
 * User: program-apprentice
 * Date: 8/14/15
 * Time: 10:36 PM
 */
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tHead = new ListNode(0);
        tHead.next = head;
        ListNode p = head.next;
        ListNode q = null;
        head.next = null;
        while(p != null) {
            q = p.next;
            p.next = tHead.next;
            tHead.next = p;
            p = q;
        }
        return tHead.next;
    }
}

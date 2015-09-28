package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 9/27/15
 * Time: 10:30 PM
 * Finished Time: 10:44 PM
 */
public class InsertionSortList_147 {
    public ListNode insertNode(ListNode head, ListNode node) {
        if(head == null) {
            head = node;
            head.next = null;
            return head;
        }
        ListNode tHead = new ListNode(0);
        tHead.next = head;
        ListNode p = tHead;
        while(p.next != null && p.next.val < node.val) {
            p = p.next;
        }
        node.next = p.next;
        p.next = node;
        return tHead.next;
    }

    public ListNode insertionSortList(ListNode head) {
        ListNode nHead = new ListNode(0);

        ListNode p = head;
        while(p != null) {
            head = head.next;
            nHead.next = insertNode(nHead.next, p);
            p = head;
        }
        return nHead.next;
    }
}

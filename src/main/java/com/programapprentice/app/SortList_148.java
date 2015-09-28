package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 9/27/15
 * Time: 10:45 PM
 * Finished Time: 11:05 PM
 */
public class SortList_148 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode firstHalf = head;
        ListNode secondHalf = pre.next;
        pre.next = null;
        firstHalf = sortList(firstHalf);
        secondHalf = sortList(secondHalf);
        return mergeTwoLists(firstHalf, secondHalf);
    }
}

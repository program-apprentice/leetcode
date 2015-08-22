package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/21/15
 * Time: 7:12 PM
 */
public class PartitionList_86 {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode less = new ListNode(0);
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode p = tmp;
        ListNode pLess = less;

        while(p.next != null) {
            if(p.next.val < x) { // wrong: } if(p.next.val < x) {
                pLess.next = p.next;
                p.next = p.next.next;
                pLess = pLess.next;
                pLess.next = null;
            } else {
                p = p.next;
            }
        }

        pLess = less;
        while(pLess.next != null) {
            pLess = pLess.next;
        }
        pLess.next = tmp.next;
        return less.next;
    }
}

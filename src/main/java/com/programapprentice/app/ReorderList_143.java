package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 9/27/15
 * Time: 12:01 PM
 */
public class ReorderList_143 {
    public ListNode reverse(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode tHead2 = new ListNode(0);
        tHead2.next = head;
        ListNode cur = head.next;

        while(cur != null) {
            head.next = cur.next;
            cur.next = tHead2.next;
            tHead2.next = cur;
            cur = head.next;
        }

        return tHead2.next;
    }

    public ListNode reorderList(ListNode head) {
        if(head == null) {
            return null;
        }
        // 1. find length
        int length = 0;
        ListNode p = head;
        while(p != null) {
            p = p.next;
            length++;
        }

        int halfSteps = length % 2 == 0 ? length / 2 : length / 2 + 1;
        ListNode tHead = new ListNode(0);
        tHead.next = head;
        p = tHead;
        for(int i = 0; i < halfSteps; i++) {
            p = p.next;
        }

        // 2. find secondhalfHead and reverse
        ListNode secondHalf = p.next;
        p.next = null;
        secondHalf = reverse(secondHalf);

        // 3. merge
        ListNode second = secondHalf;
        ListNode secondP = null;
        ListNode first = head;
        ListNode firstP = null;
        while(second != null) {
            secondP = second.next;
            firstP = first.next;
            second.next = first.next;
            first.next = second;
            first = firstP;
            second = secondP;
        }
        return tHead.next;
    }
}

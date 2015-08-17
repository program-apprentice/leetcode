package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/16/15
 * Time: 6:24 PM
 * Finished Time: 6:44 PM
 */
public class SwapNodesInPairs_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tHead = new ListNode(0);
        tHead.next = head;
        ListNode r = tHead;
        ListNode p = head;
        ListNode q = p.next;
        while(p != null) {
            p.next = q.next;
            q.next = p;
            r.next = q;
            r = p; // missed this one
            p = p.next;
            if(p == null || p.next == null) {
                break;
            } else {
                q = p.next; // this is not q = p.next.next
            }
        }
        return tHead.next;
    }
}

package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 9/27/15
 * Time: 11:29 AM
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode p = head;
        ListNode q = head;
        while(p != null && q != null) {
            p = p.next;
            q = q.next;
            if(q == null) {
                return false;
            } else {
                q = q.next;
            }
            if(q == p && p != null) {
                return true;
            }
        }
        return false;
    }
}

package com.programapprentice.app;

import com.programapprentice.util.ListNode;
import java.util.HashSet;

/**
 * User: program-apprentice
 * Date: 9/27/15
 * Time: 11:34 AM
 */
public class LinkedListCycleII_142 {
    public ListNode detectCycleUseSpace(ListNode head) {
        if(head == null) { // missing this section
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while(p != null && q != null) {
            p = p.next;
            q = q.next;
            if(p == null || q == null) {
                return null;
            } else {
                q = q.next;
            }
            if(q == p) {
                break;
            }
        }
        if(q == null) { // missing this seciton
            return null;
        }
        HashSet<ListNode> cycle = new HashSet<ListNode>();
        while(!cycle.contains(q)) {
            cycle.add(q);
            q = q.next;
        }
        ListNode r = head;
        while(!cycle.contains(r)) {
            r = r.next;
        }
        return r;
    }

    public ListNode detectCycle(ListNode head) {
        if(head == null) { // missing this section
            return null;
        }
        ListNode p = head;
        ListNode q = head;
        while(p != null && q != null) {
            p = p.next;
            q = q.next;
            if(p == null || q == null) {
                return null;
            } else {
                q = q.next;
            }
            if(q == p) {
                break;
            }
        }
        if(q == null) { // missing this seciton
            return null;
        }
        ListNode r = head;
        while(r != p) {
            r = r.next;
            p = p.next;
        }
        return r;
    }
}

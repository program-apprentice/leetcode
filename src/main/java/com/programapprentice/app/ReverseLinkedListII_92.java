package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 9/6/15
 * Time: 10:14 PM
 * Finished Time: 10:29 PM
 */
public class ReverseLinkedListII_92 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n || head == null) {
            return head;
        }
        ListNode tHead = new ListNode(0);
        tHead.next = head;
        ListNode p = tHead;
        for(int i = 0; i < m-1; i++) {
            p = p.next;
        }
        ListNode mNode = p.next;
        ListNode q = null;
        ListNode r = null;
        for(int i = 0; i < n-m; i++) { // wrong: for(int i = 0; i < n-m+1; i++) {
            r = p.next; // missing this one.
            q = mNode.next;
            p.next = q;
            mNode.next = q.next;
            q.next = r; // missing this one.
        }
        return tHead.next;
    }
}

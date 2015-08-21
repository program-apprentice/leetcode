package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/20/15
 * Time: 5:56 PM
 */
public class RotateList_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0) {
            return head;
        }
        if(head == null || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode p = head;
        while(p != null) {
            len++;
            p = p.next;
        }
        k = k % len;
        if(k == 0) {
            return head;
        }
        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode r = tmp;
        for(int i = 0; i < len - k; i++) {
            r = r.next;
        }
        ListNode tmp2 = r.next;
        r.next = null;
        tmp.next = tmp2;
        p = tmp2;
        while(p.next != null) {
            p = p.next;
        }
        p.next = head;
        return tmp.next;
    }
}

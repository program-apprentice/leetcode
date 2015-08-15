package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 2:40 PM
 * Finished Time: 3:01 PM
 */
public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) {
            return null;
        }
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }
        ListNode tHead = new ListNode(0);
        ListNode nNode = tHead;
        ListNode p1 = l1;
        ListNode p2 = l2;
        int carry = 0;
        int tmp = 0;
        while(p1 != null && p2 != null) {
            tmp = p1.val + p2.val + carry;
            nNode.next = new ListNode(tmp % 10);
            nNode = nNode.next;
            carry = tmp / 10;
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode left = p1 == null ? p2 : p1;
        while(left != null) {
            tmp = left.val + carry;
            nNode.next = new ListNode(tmp % 10);
            nNode = nNode.next;
            carry = tmp / 10;
            left = left.next;
        }
        if(carry == 1) {
            nNode.next = new ListNode(1);
        }
        return tHead.next;
    }
}

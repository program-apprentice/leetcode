package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/15/15
 * Time: 1:15 PM
 */
public class PalindromeLinkedList_234 {
    /**
     * 1. get length
     * 2. find mid point
     * 3. reverse second half
     * 4. compare
     * */
    public ListNode reverseList(ListNode head) {
        ListNode nHead = new ListNode(0);
        nHead.next = head;
        ListNode p = head.next;
        ListNode q = head;
        while(p != null) {
            q = p.next;
            p.next = nHead.next;
            nHead.next = p;
            p = q;
        }
        return nHead.next;
    }

    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) {
            return true;
        }
        int length = 0;
        ListNode p = head;
        while(p != null) {
            length++;
            p = p.next;
        }
        ListNode r = null;
        p = head;
        int halfLength = length / 2;
        for(int i = 0; i < halfLength; i++) {
            r = p;
            p = p.next;
        }
        ListNode head2 = null;
        if(length % 2 == 0) {
            head2 = p;
            r.next = null;
        } else {
            head2 = p.next;
            r.next = null;
        }
        head2 = reverseList(head2);
        p = head;
        ListNode q = head2;
        for(int i = 0; i < halfLength; i++) {
            if(p.val != q.val) {
                return false;
            }
            p = p.next;
            q = q.next;
        }
        return true;
    }
}

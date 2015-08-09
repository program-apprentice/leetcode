package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/9/15
 * Time: 11:52 AM
 */
public class RemoveDuplicatesFromSortedList_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode p = head;
        while(p.next != null) {
            if(p.next.val == p.val) {
                p.next = p.next.next;
            } else {
                p = p.next;
            }
        }
        return head;
    }
}

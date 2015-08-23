package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/23/15
 * Time: 12:50 PM
 * Finished Time: 1:07 PM
 */
public class RemoveDuplicatesFromSortedListII_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = new ListNode(0);
        ListNode r = tmp;
        ListNode pre = head;
        ListNode cur = head.next;
        boolean isDuplicate = false;
        while(cur != null) {
            if(cur.val != pre.val) {
                if(!isDuplicate) {
                    r.next = pre;
                    r = r.next;
                }
                isDuplicate = false;
            } else {
                isDuplicate = true;
            }
            pre = cur; // wrong: missing this one
            cur = cur.next; // wrong: missing this one
        }
        if(!isDuplicate) {
            r.next = pre;
            r = r.next; // wrong: missing this one
        }
        r.next = null; // wrong: missing this one
        return tmp.next;
    }
}
;

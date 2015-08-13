package com.programapprentice.app;

import com.programapprentice.util.ListNode;

/**
 * User: program-apprentice
 * Date: 8/12/15
 * Time: 10:02 PM
 */
public class IntersectionOfTwoLinkedLists_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 0;
        int lengthB = 0;

        ListNode p = headA;
        while(p != null) {
            lengthA++;
            p = p.next;
        }

        ListNode q = headB;
        while(q != null) {
            lengthB++;
            q = q.next;
        }
        int diff = Math.abs(lengthA - lengthB);
        if(lengthB > lengthA) {
            p = headA;
            q = headB;
        } else {
            p = headB;
            q = headA;
        }
        for(int i = 0; i < diff; i++) {
            q = q.next;
        }
        while(q != null && p != null) {
            if(q == p) {
                return q;
            }
            p = p.next;
            q = q.next;
        }
        return null;
    }
}

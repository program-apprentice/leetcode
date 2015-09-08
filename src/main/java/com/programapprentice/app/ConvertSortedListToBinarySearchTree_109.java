package com.programapprentice.app;

import com.programapprentice.util.ListNode;
import com.programapprentice.util.TreeNode;

/**
 * User: program-apprentice
 * Date: 9/7/15
 * Time: 4:38 PM
 */
public class ConvertSortedListToBinarySearchTree_109 {
    private ListNode listNode;
    public TreeNode sortedListToBST(ListNode head) {
        int n = 0;
        ListNode p = head;
        while(p != null) {
            n++;
            p = p.next;
        }
        listNode = head;
        return sortedListToBST(0, n-1);
    }

    public TreeNode sortedListToBST(int start, int end) {
        if(start > end) {
            return null;
        }
        int mid = (start + end)/2;
        TreeNode left = sortedListToBST(start, mid-1);
        TreeNode root = new TreeNode(listNode.val);
        root.left = left;
        listNode = listNode.next;
        root.right = sortedListToBST( mid+1, end);
        return root;
    }
}

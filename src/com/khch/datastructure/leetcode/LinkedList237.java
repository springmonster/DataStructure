package com.khch.datastructure.leetcode;

/**
 * delete node in a linked list
 */
public class LinkedList237 {
    public static void main(String[] args) {
        ListNode listNode0 = new ListNode(4);
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(9);

        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;

        new Solution237().deleteNode(listNode2);

        ListNode temp = listNode0;
        while (temp != null) {
            System.out.print(" " + temp.val);
            temp = temp.next;
        }
    }
}

//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class Solution237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

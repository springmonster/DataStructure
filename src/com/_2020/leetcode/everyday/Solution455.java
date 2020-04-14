package com._2020.leetcode.everyday;


import java.util.Stack;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution455 {
    public static void main(String[] args) {
//        ListNode listNode11 = new ListNode(7);
//        ListNode listNode12 = new ListNode(2);
//        ListNode listNode13 = new ListNode(4);
//        ListNode listNode14 = new ListNode(3);
//        listNode11.next = listNode12;
//        listNode12.next = listNode13;
//        listNode13.next = listNode14;
//
//        ListNode listNode21 = new ListNode(5);
//        ListNode listNode22 = new ListNode(6);
//        ListNode listNode23 = new ListNode(4);
//        listNode21.next = listNode22;
//        listNode22.next = listNode23;

        ListNode listNode11 = new ListNode(5);

        ListNode listNode21 = new ListNode(5);

        ListNode result = addTwoNumbers(listNode11, listNode21);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        Stack<ListNode> stack3 = new Stack<>();
        while (l1 != null) {
            stack1.push(l1);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2);
            l2 = l2.next;
        }

        int moreThanTenValue = 0;
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            int result = stack1.pop().val + stack2.pop().val + moreThanTenValue;
            if (result < 10) {
                moreThanTenValue = 0;
                ListNode listNode = new ListNode(result);
                stack3.push(listNode);
            } else {
                moreThanTenValue = 1;
                ListNode listNode = new ListNode(result - 10);
                stack3.push(listNode);
            }
        }
        while (!stack1.isEmpty()) {
            int result = stack1.pop().val + moreThanTenValue;
            if (result < 10) {
                moreThanTenValue = 0;
                ListNode listNode = new ListNode(result);
                stack3.push(listNode);
            } else {
                moreThanTenValue = 1;
                ListNode listNode = new ListNode(result - 10);
                stack3.push(listNode);
            }
        }
        while (!stack2.isEmpty()) {
            int result = stack2.pop().val + moreThanTenValue;
            if (result < 10) {
                moreThanTenValue = 0;
                ListNode listNode = new ListNode(result);
                stack3.push(listNode);
            } else {
                moreThanTenValue = 1;
                ListNode listNode = new ListNode(result - 10);
                stack3.push(listNode);
            }
        }
        if (moreThanTenValue == 1) {
            ListNode listNode = new ListNode(1);
            stack3.push(listNode);
        }

        ListNode head = stack3.peek();
        ListNode current = head;
        stack3.pop();
        while (!stack3.isEmpty()) {
            ListNode tempNode = new ListNode(stack3.pop().val);
            current.next = tempNode;
            current = tempNode;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

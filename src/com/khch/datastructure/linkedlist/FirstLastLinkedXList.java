package com.khch.datastructure.linkedlist;

/**
 * 这是一个双端链表
 * First指向头
 * Last指向尾
 */
public class FirstLastLinkedXList {
    NodeX first;
    NodeX last;

    public void insertFirst(int value) {
        NodeX nodeX = new NodeX();
        nodeX.value = value;
        nodeX.next = first;
        first = nodeX;
        if (last == null) {
            last = first;
        }
    }

    public void insertLast(int value) {
        NodeX nodeX = new NodeX();
        nodeX.value = value;
        if (first == null && last == null) {
            first = last = nodeX;
        } else {
            last.next = nodeX;
            last = nodeX;
        }
    }

    public void delete() {

    }

    public void display() {
        System.out.println();
        NodeX nodeX = first;
        while (nodeX != null) {
            System.out.print(nodeX.value + " ");
            nodeX = nodeX.next;
        }
        System.out.println();
    }

    public void displayFirstAndLast() {
        System.out.println(String.format("first is %d and last is %d", first.value, last.value));
    }
}

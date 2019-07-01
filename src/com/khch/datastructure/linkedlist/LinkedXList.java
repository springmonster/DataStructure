package com.khch.datastructure.linkedlist;

public class LinkedXList {
    NodeX first;

    public void insert(int value) {
        NodeX nodeX = new NodeX();
        nodeX.value = value;
        nodeX.next = first;
        first = nodeX;
    }

    public void delete(int value) {
        if (first != null) {
            NodeX previous = first;
            NodeX next = first.next;
            while (next != null) {
                if (next.value == value) {
                    previous.next = next.next;
                    break;
                } else {
                    previous = next;
                    next = next.next;
                }
            }
        }
    }

    public void display() {
        System.out.println("--------------------------");
        if (first != null) {
            NodeX nodeX = first;
            while (nodeX != null) {
                System.out.print(nodeX.value + " ");
                nodeX = nodeX.next;
            }
        }
        System.out.println();
        System.out.println("--------------------------");
    }
}

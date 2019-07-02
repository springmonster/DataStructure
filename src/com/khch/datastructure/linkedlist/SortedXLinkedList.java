package com.khch.datastructure.linkedlist;

public class SortedXLinkedList {
    private NodeX first;
    private NodeX previous;

    public void insert(int value) {
        NodeX nodeX = new NodeX();
        nodeX.value = value;

        if (first == null) {
            previous = null;
            first = nodeX;
        } else {
            NodeX current = first;
            while (current != null) {
                if (current.value < value) {
                    previous = current;
                    current = current.next;
                } else {
                    break;
                }
            }
            if (current == first) {
                nodeX.next = first;
                first = nodeX;
            } else {
                nodeX.next = current;
                previous.next = nodeX;
            }
        }
    }

    public int getMinValue() {
        if (first == null) {
            throw new IllegalArgumentException();
        } else {
            int temp = first.value;
            first = first.next;
            return temp;
        }
    }

    public void display() {
        System.out.println("----------------------------");
        NodeX current = first;
        while (current != null) {
            System.out.print(current.value + " ");
            current = current.next;
        }
        System.out.println();
    }
}

package com.khch.datastructure.linkedlist;

public class SortedXLinkedListMain {
    public static void main(String[] args) {
        SortedXLinkedList sortedXLinkedList = new SortedXLinkedList();
        sortedXLinkedList.insert(5);
        sortedXLinkedList.insert(4);
        sortedXLinkedList.insert(3);
        sortedXLinkedList.insert(2);
        sortedXLinkedList.insert(1);
        sortedXLinkedList.insert(8);
        sortedXLinkedList.insert(9);
        sortedXLinkedList.insert(7);
        sortedXLinkedList.insert(6);

        sortedXLinkedList.display();

        sortedXLinkedList.getMinValue();
        sortedXLinkedList.getMinValue();
        sortedXLinkedList.getMinValue();
        sortedXLinkedList.getMinValue();

        sortedXLinkedList.display();
    }
}

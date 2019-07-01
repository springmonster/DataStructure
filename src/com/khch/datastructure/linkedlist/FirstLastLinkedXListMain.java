package com.khch.datastructure.linkedlist;

public class FirstLastLinkedXListMain {
    public static void main(String[] args) {
        FirstLastLinkedXList firstLastLinkedXList = new FirstLastLinkedXList();
        firstLastLinkedXList.insertFirst(1);
        firstLastLinkedXList.displayFirstAndLast();
        firstLastLinkedXList.insertFirst(2);
        firstLastLinkedXList.displayFirstAndLast();
        firstLastLinkedXList.insertFirst(3);
        firstLastLinkedXList.displayFirstAndLast();
        firstLastLinkedXList.insertLast(4);
        firstLastLinkedXList.displayFirstAndLast();
        firstLastLinkedXList.insertLast(5);
        firstLastLinkedXList.displayFirstAndLast();
        firstLastLinkedXList.insertLast(6);
        firstLastLinkedXList.displayFirstAndLast();

        firstLastLinkedXList.display();
    }
}

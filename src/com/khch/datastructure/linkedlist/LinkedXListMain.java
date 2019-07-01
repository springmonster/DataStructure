package com.khch.datastructure.linkedlist;

public class LinkedXListMain {
    public static void main(String[] args) {
        LinkedXList linkedXList = new LinkedXList();
        linkedXList.insert(1);
        linkedXList.insert(2);
        linkedXList.insert(3);
        linkedXList.insert(4);
        linkedXList.insert(5);
        linkedXList.insert(6);

        linkedXList.display();

        linkedXList.delete(4);
        linkedXList.delete(3);

        linkedXList.display();
    }
}

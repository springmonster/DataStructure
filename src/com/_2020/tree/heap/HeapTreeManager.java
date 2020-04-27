package com._2020.tree.heap;

public class HeapTreeManager {

    public static void main(String[] args) {
        HeapTree heapTree = new HeapTree(10);
        heapTree.insert(1);
        heapTree.insert(2);
        heapTree.insert(3);
        heapTree.insert(4);
        heapTree.insert(5);
        heapTree.display();

        int i = heapTree.deleteMax();
        System.out.println("max is " + i);
        i = heapTree.deleteMax();
        System.out.println("max is " + i);
        i = heapTree.deleteMax();
        System.out.println("max is " + i);
        i = heapTree.deleteMax();
        System.out.println("max is " + i);
        i = heapTree.deleteMax();
        System.out.println("max is " + i);
//        heapTree.display();
    }
}

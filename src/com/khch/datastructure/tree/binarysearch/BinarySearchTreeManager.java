package com.khch.datastructure.tree.binarysearch;

public class BinarySearchTreeManager {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(5);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(7);
        binarySearchTree.insert(8);
        binarySearchTree.insert(8);
        binarySearchTree.insert(6);
        binarySearchTree.display();

        boolean isFind = binarySearchTree.find(100);
        System.out.println(String.format("find %d result is %b", 100, isFind));

        isFind = binarySearchTree.find(4);
        System.out.println(String.format("find %d result is %b", 4, isFind));
    }
}

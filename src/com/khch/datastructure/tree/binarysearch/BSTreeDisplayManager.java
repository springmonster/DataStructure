package com.khch.datastructure.tree.binarysearch;

public class BSTreeDisplayManager {
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        binarySearchTree.insert(3);
        binarySearchTree.insert(2);
        binarySearchTree.insert(8);
        binarySearchTree.insert(9);
        binarySearchTree.insert(10);
        binarySearchTree.insert(4);

        binarySearchTree.preOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.midOrder(binarySearchTree.root);
        System.out.println();
        binarySearchTree.posOrder(binarySearchTree.root);
        System.out.println();
        System.out.println("---------------------DFS---------------------");
        binarySearchTree.preOrderDFS(binarySearchTree.root);
        System.out.println();
        binarySearchTree.midOrderDFS(binarySearchTree.root);
        System.out.println();
//        binarySearchTree.posOrderDFS(binarySearchTree.root);
//        System.out.println();
    }
}

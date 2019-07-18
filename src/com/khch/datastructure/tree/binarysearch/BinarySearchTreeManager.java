package com.khch.datastructure.tree.binarysearch;

public class BinarySearchTreeManager {

    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = createBinarySearchTree();
        binarySearchTree.display();

        System.out.println("查找");
        boolean isFind = binarySearchTree.find(100);
        System.out.println(String.format("find %d result is %b", 100, isFind));

        isFind = binarySearchTree.find(4);
        System.out.println(String.format("find %d result is %b", 4, isFind));

        System.out.println("删除40");
        binarySearchTree = createBinarySearchTree();
        binarySearchTree.display();
        binarySearchTree.delete(40);
        binarySearchTree.display();

        System.out.println("删除30");
        binarySearchTree = createBinarySearchTree();
        binarySearchTree.display();
        binarySearchTree.delete(30);
        binarySearchTree.display();

        System.out.println("删除35");
        binarySearchTree = createBinarySearchTree();
        binarySearchTree.display();
        binarySearchTree.delete(35);
        binarySearchTree.display();

        System.out.println("删除60");
        binarySearchTree = createBinarySearchTree();
        binarySearchTree.display();
        binarySearchTree.delete(60);
        binarySearchTree.display();

        System.out.println("删除70");
        binarySearchTree = createBinarySearchTree();
        binarySearchTree.display();
        binarySearchTree.delete(70);
        binarySearchTree.display();

        System.out.println("删除50");
        binarySearchTree = createBinarySearchTree();
        binarySearchTree.display();
        binarySearchTree.delete(50);
        binarySearchTree.display();

        System.out.println("删除50");
        binarySearchTree = createBinarySearchTree1();
        binarySearchTree.display();
        binarySearchTree.delete(40);
        binarySearchTree.display();
    }

    private static BinarySearchTree createBinarySearchTree() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(50);
        binarySearchTree.insert(30);
        binarySearchTree.insert(40);
        binarySearchTree.insert(35);
        binarySearchTree.insert(70);
        binarySearchTree.insert(80);
        binarySearchTree.insert(80);
        binarySearchTree.insert(60);
        binarySearchTree.insert(55);
        binarySearchTree.insert(56);
        binarySearchTree.insert(61);
        return binarySearchTree;
    }

    private static BinarySearchTree createBinarySearchTree1() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insert(50);
        binarySearchTree.insert(40);
        binarySearchTree.insert(60);
        binarySearchTree.insert(30);
        binarySearchTree.insert(45);
        binarySearchTree.insert(44);
        binarySearchTree.insert(42);
        binarySearchTree.insert(43);
        binarySearchTree.insert(48);
        binarySearchTree.insert(47);
        binarySearchTree.insert(49);
        return binarySearchTree;
    }
}

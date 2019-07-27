package com.khch.datastructure.tree.avl;

public class AVLTreeManager {

    public static void main(String[] args) {

        AVLTree aTree = new AVLTree();
        int[] arr = {3, 2, 1, 4, 5, 6, 7, 10, 9, 8};
        for (int i : arr) {
            aTree.insert(i);
        }
        System.out.println("\n前序遍历结果：");
        aTree.preOrder();
        System.out.println("\n中序遍历结果：");
        aTree.inOrder();

        System.out.println("\n----------------------------------\n");
        AVLTree aTree1 = new AVLTree();
        int[] arr1 = {3, 2, 1, 4, 5, 6, 7, 16, 15, 14, 13, 12, 11, 10, 8, 9};
        for (int i : arr1) {
            aTree1.insert(i);
        }
        System.out.println("\n前序遍历结果：");
        aTree1.preOrder();
        System.out.println("\n中序遍历结果：");
        aTree1.inOrder();
    }
}

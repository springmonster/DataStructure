package com.khch.datastructure.tree.binarysearch;

public class BSTreeNode {
    BSTreeNode leftChild;
    BSTreeNode rightChild;
    int value;
    // 为了DFS的后序遍历
    boolean isVisited;
}

package com.khch.datastructure.tree.avl;

public class AVLNode {
    AVLNode left;
    AVLNode right;
    int balanceFactor;
    int value;

    public AVLNode() {

    }

    public AVLNode(int value) {
        this.value = value;
    }
}

package com.khch.datastructure.tree.redblack;

public class RBTreeManager {
    public static void main(String[] args) {
        RBTree rbTree = new RBTree();
        rbTree.insert(50);
        rbTree.insert(35);
        rbTree.insert(27);
        rbTree.insert(45);
        rbTree.insert(40);
        rbTree.insert(48);
        rbTree.insert(78);
        rbTree.insert(56);
        rbTree.insert(90);

        rbTree.display();
    }
}

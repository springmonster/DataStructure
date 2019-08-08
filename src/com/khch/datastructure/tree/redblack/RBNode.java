package com.khch.datastructure.tree.redblack;

public class RBNode implements Comparable<RBNode> {
    public int value;
    RBNode leftChild;
    RBNode rightChild;
    boolean isRed = true;
    RBNode parent;

    @Override
    public int compareTo(RBNode o) {
        return value - o.value;
    }
}

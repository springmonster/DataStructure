package com.khch.datastructure.tree.twothree;

/**
 * 2-3树的节点
 * 2节点，value有一个，子节点两个
 * 3节点，value有两个，子节点三个
 */
class TTNode {
    // 是否是2节点或者3节点
    private boolean isTwo;

    // 2节点
    private TTNode left;
    private TTNode right;
    private int value;

    private TTNode middle; // 3节点才有
    private int value1; // 3节点才有

    // 父节点
    private TTNode father;

    public boolean isTwo() {
        return isTwo;
    }

    public void setTwo(boolean two) {
        isTwo = two;
    }

    public TTNode getLeft() {
        return left;
    }

    public void setLeft(TTNode left) {
        this.left = left;
    }

    public TTNode getRight() {
        return right;
    }

    public void setRight(TTNode right) {
        this.right = right;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TTNode getMiddle() {
        return middle;
    }

    public void setMiddle(TTNode middle) {
        this.middle = middle;
    }

    public int getValue1() {
        return value1;
    }

    public void setValue1(int value1) {
        this.value1 = value1;
    }

    public TTNode getFather() {
        return father;
    }

    public void setFather(TTNode father) {
        this.father = father;
    }
}

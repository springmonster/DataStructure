package com.khch.datastructure.tree.twothree;

public class TwoThreeTree {
    private TTNode root;

    public void insert(int value) {
        if (root == null) {
            TTNode ttNode = new TTNode();
            ttNode.setValue(value);
            ttNode.setTwo(true);
            root = ttNode;
            return;
        }

        // 这里分几种情况
        // 如果是2-结点，转换为3-结点
        // 如果是3-结点，转换为3个2-结点
        // 如果父节点是2-结点，插入的为3-结点
        // 如果父节点是3-结点，插入的为3-结点
        // 如果插入结点到根节点都是3-结点，则根节点变为临时的4结点，再分解
    }

    private boolean find(TTNode ttNode, int value) {
        if (ttNode == null) {
            return false;
        }
        if (ttNode.isTwo()) {
            if (value < ttNode.getValue()) {
                find(ttNode.getLeft(), value);
            } else if (value > ttNode.getValue()) {
                find(ttNode.getRight(), value);
            } else {
                return true;
            }
        } else {
            if (value < ttNode.getValue()) {
                find(ttNode.getLeft(), value);
            } else if (value > ttNode.getValue() && value < ttNode.getValue1()) {
                find(ttNode.getMiddle(), value);
            } else if (value > ttNode.getValue1()) {
                find(ttNode.getRight(), value);
            } else {
                return true;
            }
        }
        return false;
    }

    private void adjustTree() {

    }

    public void display() {
        if (root != null) {
            displayNode(root);
        } else {
            System.out.println("2-3树是空的");
        }
    }

    private void displayNode(TTNode ttNode) {
        if (ttNode != null) {
            if (ttNode.isTwo()) {
                System.out.print(ttNode.getValue() + " ");
            } else {
                System.out.print(ttNode.getValue() + " " + ttNode.getValue1() + " ");
            }
            if (ttNode.isTwo()) {
                displayNode(ttNode.getLeft());
                displayNode(ttNode.getRight());
            } else {
                displayNode(ttNode.getLeft());
                displayNode(ttNode.getMiddle());
                displayNode(ttNode.getRight());
            }
        }
    }
}

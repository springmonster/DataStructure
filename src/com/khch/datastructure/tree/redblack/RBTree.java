package com.khch.datastructure.tree.redblack;

/**
 * 不允许插入相同的数据
 */
public class RBTree {
    private RBNode root;
    private RBNode currentNode;
    private RBNode currentParentNode;
    private RBNode currentParentParentNode;
    private boolean isLeft;

    public void insert(int value) {
        RBNode rbNode = new RBNode();
        rbNode.value = value;

        if (root == null) {
            rbNode.isRed = false;
            root = rbNode;
        } else {
            // 如果左右孩子都不为空
            currentNode = root;

            if (currentNode.leftChild != null && currentNode.rightChild != null) {
                if (currentNode.leftChild.isRed && currentNode.rightChild.isRed) {
                    currentNode.leftChild.isRed = false;
                    currentNode.rightChild.isRed = false;
                    currentNode.isRed = currentNode != root;
                }
                while (currentNode != null) {
                    if (value < currentNode.value) {
                        currentParentParentNode = currentParentNode;
                        currentParentNode = currentNode;
                        currentNode = currentNode.leftChild;
                        isLeft = true;
                    } else {
                        currentParentParentNode = currentParentNode;
                        currentParentNode = currentNode;
                        currentNode = currentNode.rightChild;
                        isLeft = false;
                    }
                }
                if (isLeft) {
                    currentParentNode.leftChild = rbNode;
                    currentNode = rbNode;
                    if (!currentParentNode.isRed) {
                        // 不需要变换颜色
                    }
                } else {
                    currentParentNode.rightChild = rbNode;
                    currentNode = rbNode;
                    if (!currentParentNode.isRed) {
                        // 不需要变换颜色
                    }
                }
            } else if (currentNode.leftChild == null && currentNode.rightChild == null) {
                // 说明是根节点
                if (value < currentNode.value) {
                    currentNode.leftChild = rbNode;
                } else {
                    currentNode.rightChild = rbNode;
                }
            } else if (currentNode.leftChild != null && currentNode.rightChild == null) {
                if (value > currentNode.value) {
                    currentNode.rightChild = rbNode;
                } else {

                }
            } else if (currentNode.leftChild == null && currentNode.rightChild != null) {
                if (value < currentNode.value) {
                    currentNode.leftChild = rbNode;
                }
            }
        }
    }

    private void llRotate() {

    }

    private void rrRotate() {

    }

    private void lrRotate() {

    }

    private void rlRotate() {
    }

    public void display() {
        midOrder(root);
    }

    private void midOrder(RBNode rbNode) {
        if (rbNode == null) {
            return;
        }
        midOrder(rbNode.leftChild);
        String colorStr = rbNode.isRed ? "红" : "黑";
        System.out.println(String.format("%d %s", rbNode.value, colorStr));
        midOrder(rbNode.rightChild);
    }
}

package com.charles.tree.bst;

public class BSTreeManager {

    // 7,5,6,3,4,9,8,12,10,13,11
    public static void main(String[] args) {
        BSTTree bstTree = new BSTTree();

        bstTree.insert(7);
        bstTree.insert(5);
        bstTree.insert(6);
        bstTree.insert(3);
        bstTree.insert(4);
        bstTree.insert(9);
        bstTree.insert(8);
        bstTree.insert(12);
        bstTree.insert(10);
        bstTree.insert(13);
        bstTree.insert(11);

        bstTree.preOrderDisplay();
        bstTree.inOrderDisplay();

        boolean result = bstTree.delete(9);
        System.out.println(String.format("\n删除%s", result ? "成功" : "失败"));
        bstTree.preOrderDisplay();
        bstTree.inOrderDisplay();
    }
}

class BSTTreeNode {
    BSTTreeNode left;
    BSTTreeNode right;
    int value;
}

class BSTTree {
    BSTTreeNode root;

    /**
     * 不考虑相同value的情况
     *
     * @param value
     */
    void insert(int value) {
        BSTTreeNode newNode = new BSTTreeNode();
        newNode.value = value;

        if (root == null) {
            root = newNode;
            return;
        }

        BSTTreeNode currentNode = root;
        BSTTreeNode currentParentNode = null;

        while (currentNode != null) {
            currentParentNode = currentNode;

            if (value < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                currentNode = currentNode.right;
            }
        }

        if (value < currentParentNode.value) {
            currentParentNode.left = newNode;
        } else {
            currentParentNode.right = newNode;
        }
    }

    /*
     * 1. 查找节点
     * 2. 删除节点
     *  A. 如果要删除的节点没有子节点
     *  B. 如果要删除的节点只有一个子节点
     *  C. 如果要删除的节点有两个子节点
     *
     * @param value
     */
    boolean delete(int value) {
        if (root == null) {
            return false;
        }

        BSTTreeNode currentNode = root;
        BSTTreeNode currentParentNode = root;

        while (currentNode != null) {
            if (value < currentNode.value) {
                currentParentNode = currentNode;
                currentNode = currentNode.left;
            } else if (value > currentNode.value) {
                currentParentNode = currentNode;
                currentNode = currentNode.right;
            } else {
                break;
            }
        }

        if (currentNode == null) {
            return false;
        }

        // A. 如果要删除的节点没有子节点
        if (currentNode.left == null && currentNode.right == null) {
            if (value < currentParentNode.value) {
                currentParentNode.left = null;
            } else {
                currentParentNode.right = null;
            }
        } else if (currentNode.left == null) {
            // B. 如果要删除的节点只有一个子节点
            if (value < currentParentNode.value) {
                currentParentNode.left = currentNode.right;
            } else {
                currentParentNode.right = currentNode.right;
            }
        } else if (currentNode.right == null) {
            // B. 如果要删除的节点只有一个子节点
            if (value < currentParentNode.value) {
                currentParentNode.left = currentNode.left;
            } else {
                currentParentNode.right = currentNode.left;
            }
        } else {
            // C. 如果要删除的节点有两个子节点
            // currentParentNode代表的为要删除节点的父节点
            // currentNode代表的为要删除节点
            BSTTreeNode minInMaxNode = currentNode.right;
            BSTTreeNode minInMaxParentNode = minInMaxNode;
            BSTTreeNode minInMaxGrandParentNode = minInMaxNode;

            while (minInMaxNode != null) {
                minInMaxGrandParentNode = minInMaxParentNode;
                minInMaxParentNode = minInMaxNode;
                minInMaxNode = minInMaxNode.left;
            }

            minInMaxGrandParentNode.left = minInMaxParentNode.right;
            minInMaxParentNode.left = currentNode.left;
            minInMaxParentNode.right = currentNode.right;
            if (value < currentParentNode.value) {
                currentParentNode.left = minInMaxParentNode;
            } else {
                currentParentNode.right = minInMaxParentNode;
            }
        }
        return true;
    }

    void preOrderDisplay() {
        System.out.println("\n前序遍历开始");
        preOrderTraversal(root);
        System.out.println("\n前序遍历结束");
    }

    private void preOrderTraversal(BSTTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    void inOrderDisplay() {
        System.out.println("\n中序遍历开始");
        inOrderTraversal(root);
        System.out.println("\n中序遍历结束");
    }

    private void inOrderTraversal(BSTTreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(" " + node.value);
        inOrderTraversal(node.right);
    }
}
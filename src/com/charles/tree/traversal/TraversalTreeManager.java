package com.charles.tree.traversal;

public class TraversalTreeManager {

    public static void main(String[] args) {
        TraversalTree traversalTree = new TraversalTree();

        traversalTree.insert(7);
        traversalTree.insert(5);
        traversalTree.insert(3);
        traversalTree.insert(4);
        traversalTree.insert(9);
        traversalTree.insert(8);
        traversalTree.insert(11);
        traversalTree.insert(10);

        traversalTree.preOrderDisplay();
        traversalTree.inOrderDisplay();
        traversalTree.postOrderDisplay();
    }
}

class TraversalTreeNode {
    TraversalTreeNode left;
    TraversalTreeNode right;
    int value;
}

class TraversalTree {

    TraversalTreeNode root;

    /**
     * 不考虑相同value的情况
     *
     * @param value
     */
    void insert(int value) {
        TraversalTreeNode newNode = new TraversalTreeNode();
        newNode.value = value;

        if (root == null) {
            root = newNode;
            return;
        }

        TraversalTreeNode currentNode = root;
        TraversalTreeNode currentParentNode = null;

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

    void preOrderDisplay() {
        System.out.println("\n前序遍历开始");
        preOrderTraversal(root);
        System.out.println("\n前序遍历结束");
    }

    private void preOrderTraversal(TraversalTreeNode node) {
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

    private void inOrderTraversal(TraversalTreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(" " + node.value);
        inOrderTraversal(node.right);
    }

    void postOrderDisplay() {
        System.out.println("\n后序遍历开始");
        postOrderTraversal(root);
        System.out.println("\n后序遍历结束");
    }

    private void postOrderTraversal(TraversalTreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(" " + node.value);
    }
}
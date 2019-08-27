package com.charles.tree.traversal;

import java.util.LinkedList;
import java.util.Stack;

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
        traversalTree.levelOrderDisplay();
    }
}

class TraversalTreeNode {
    TraversalTreeNode left;
    TraversalTreeNode right;
    int value;
    boolean isVisited;
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
        System.out.println("递归前序遍历");
        preOrderTraversal(root);
        System.out.println("\nDFS前序遍历");
        preOrderTraversalDFS();
        System.out.println("\n前序遍历结束");
    }

    /**
     * 递归前序遍历
     *
     * @param node
     */
    private void preOrderTraversal(TraversalTreeNode node) {
        if (node == null) {
            return;
        }
        System.out.print(" " + node.value);
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /**
     * DFS前序遍历
     */
    private void preOrderTraversalDFS() {
        Stack<TraversalTreeNode> stack = new Stack<>();
        TraversalTreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                System.out.print(" " + currentNode.value);
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!stack.isEmpty()) {
                currentNode = stack.pop().right;
            }
        }
    }

    void inOrderDisplay() {
        System.out.println("\n中序遍历开始");
        System.out.println("递归中序遍历");
        inOrderTraversal(root);
        System.out.println("\nDFS中序遍历");
        inOrderTraversalDFS();
        System.out.println("\n中序遍历结束");
    }

    /**
     * 递归中序遍历
     *
     * @param node
     */
    private void inOrderTraversal(TraversalTreeNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(" " + node.value);
        inOrderTraversal(node.right);
    }

    /**
     * DFS中序遍历
     */
    private void inOrderTraversalDFS() {
        Stack<TraversalTreeNode> stack = new Stack<>();
        TraversalTreeNode currentNode = root;

        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            if (!stack.isEmpty()) {
                currentNode = stack.pop();
                System.out.print(" " + currentNode.value);
                currentNode = currentNode.right;
            }
        }
    }

    void postOrderDisplay() {
        System.out.println("\n后序遍历开始");
        System.out.println("递归后序遍历");
        postOrderTraversal(root);
        System.out.println("\nDFS后序遍历");
        postOrderTraversalDFS();
        System.out.println("\n后序遍历结束");
    }

    /**
     * 递归后序遍历
     *
     * @param node
     */
    private void postOrderTraversal(TraversalTreeNode node) {
        if (node == null) {
            return;
        }
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(" " + node.value);
    }

    /**
     * DFS后序遍历
     */
    private void postOrderTraversalDFS() {
        if (root == null) {
            return;
        }
        Stack<TraversalTreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TraversalTreeNode bsTreeNode = stack.peek();
            if (bsTreeNode.right == null && bsTreeNode.left == null) {
                TraversalTreeNode bsTreeNode1 = stack.pop();
                System.out.print(" " + bsTreeNode1.value);
                bsTreeNode1.isVisited = true;
            } else {
                if (bsTreeNode.right != null && !bsTreeNode.right.isVisited) {
                    stack.push(bsTreeNode.right);
                }
                if (bsTreeNode.left != null && !bsTreeNode.left.isVisited) {
                    stack.push(bsTreeNode.left);
                }
                if (isChildrenVisited(bsTreeNode)) {
                    TraversalTreeNode bsTreeNode1 = stack.pop();
                    System.out.print(" " + bsTreeNode1.value);
                    bsTreeNode1.isVisited = true;
                }
            }
        }
    }

    private boolean isChildrenVisited(TraversalTreeNode bsTreeNode) {
        // 左右不为空，visited都为true
        // 左不为空右为空，visited为true
        // 左为空右不为空，visited为true
        return (bsTreeNode.left != null && bsTreeNode.left.isVisited
                && bsTreeNode.right != null && bsTreeNode.right.isVisited)
                || (bsTreeNode.left != null && bsTreeNode.left.isVisited
                && bsTreeNode.right == null)
                || (bsTreeNode.left == null
                && bsTreeNode.right != null && bsTreeNode.right.isVisited);
    }

    /**
     * 层级遍历
     */
    void levelOrderDisplay() {
        if (root == null) {
            return;
        }

        System.out.println("\n层级遍历开始");

        LinkedList<TraversalTreeNode> queue = new LinkedList<>();
        queue.push(root);

        while (!queue.isEmpty()) {
            TraversalTreeNode currentNode = queue.poll();
            System.out.print(" " + currentNode.value);
            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }
        }

        System.out.println("\n层级遍历结束");
    }
}
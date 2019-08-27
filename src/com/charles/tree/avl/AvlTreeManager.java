package com.charles.tree.avl;

public class AvlTreeManager {

    public static void main(String[] args) {
        AvlTree avlTree = new AvlTree();
        avlTree.insert(3);
        avlTree.insert(2);
        avlTree.insert(1);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        avlTree.insert(10);
        avlTree.insert(9);
        avlTree.insert(8);

        avlTree.preOrderDisplay();
        avlTree.inOrderDisplay();
    }
}

class AvlTree {
    private static final int MAX_BALANCE = 1;
    private AvlNode root;

    void insert(int value) {
        root = insert(root, value);
    }

    /**
     * 假设不能插入同样的value
     *
     * @param node
     * @param value
     * @return
     */
    AvlNode insert(AvlNode node, int value) {
        if (node == null) {
            AvlNode avlNode = new AvlNode();
            avlNode.value = value;
            return avlNode;
        }

        if (value < node.value) {
            node.left = insert(node.left, value);
        } else if (value > node.value) {
            node.right = insert(node.right, value);
        } else {
            // do nothing;
        }

        return balance(node);
    }

    AvlNode balance(AvlNode node) {
        if (node == null) {
            return node;
        }

        if (height(node.left) - height(node.right) > MAX_BALANCE) {
            if (height(node.left.left) >= height(node.left.right)) {
                node = rightRotate(node);
            } else {
                node = lRInsert(node);
            }
        } else if (height(node.right) - height(node.left) > MAX_BALANCE) {
            if (height(node.right.right) >= height(node.right.left)) {
                node = leftRotate(node);
            } else {
                node = rLInsert(node);
            }
        } else {
            // do nothing
        }

        node.height = Integer.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    int height(AvlNode avlNode) {
        if (avlNode == null) {
            return -1;
        } else {
            return avlNode.height;
        }
    }

    /**
     * 右旋，当LL的时候
     *
     * @param node
     * @return
     */
    AvlNode rightRotate(AvlNode node) {
        AvlNode leftChild = node.left;
        node.left = leftChild.right;
        leftChild.right = node;
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
        leftChild.height = Integer.max(height(leftChild.left), height(node)) + 1;
        return leftChild;
    }

    /**
     * 左旋，当RR的时候
     *
     * @param node
     * @return
     */
    AvlNode leftRotate(AvlNode node) {
        AvlNode rightChild = node.right;
        node.right = rightChild.left;
        rightChild.left = node;
        node.height = Integer.max(height(node.left), height(node.right)) + 1;
        rightChild.height = Integer.max(height(node), height(rightChild.right)) + 1;
        return rightChild;
    }

    /**
     * 当LR的时候，先左旋后右旋
     */
    AvlNode lRInsert(AvlNode node) {
        node.left = leftRotate(node.left);
        return rightRotate(node);
    }

    /**
     * 当RL的时候，先右旋后左旋
     */
    AvlNode rLInsert(AvlNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }

    void preOrderDisplay() {
        System.out.println("\n前序遍历开始");
        preOrderTraversal(root);
        System.out.println("\n前序遍历结束");
    }

    /**
     * 递归前序遍历
     *
     * @param node
     */
    private void preOrderTraversal(AvlNode node) {
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

    /**
     * 递归中序遍历
     *
     * @param node
     */
    private void inOrderTraversal(AvlNode node) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left);
        System.out.print(" " + node.value);
        inOrderTraversal(node.right);
    }
}

class AvlNode {
    AvlNode left;
    AvlNode right;
    int value;
    int height;
}
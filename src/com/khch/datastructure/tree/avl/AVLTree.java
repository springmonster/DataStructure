package com.khch.datastructure.tree.avl;

public class AVLTree {

    private AVLNode root;

    // 树是否长高
    private boolean isTaller;

    /**
     * 右旋处理
     * father
     * /     \
     * child sub
     * /    \
     * sub  sub
     * /
     * node
     *
     * @param father AVLNode
     */
    private AVLNode rightRotate(AVLNode father) {
        AVLNode child = father.left;
        father.left = child.right;
        child.right = father;
        father = child;
        return father;
    }

    /**
     * 左旋处理
     *
     * @param father AVLNode
     */
    private AVLNode leftRotate(AVLNode father) {
        AVLNode child = father.right;
        father.right = child.left;
        child.left = father;
        father = child;
        return father;
    }

    /**
     * balanceFactor为0时，左右子树高度一样
     * balanceFactor为1时，左子树比右子树高
     * balanceFactor为-1时，左子树比右子树矮
     *
     * @param father AVLNode
     */
    private AVLNode leftBalance(AVLNode father) {
        switch (father.left.balanceFactor) {
            case 1:
                // 说明插入在了左孩子的左子树上，需要进行右旋
                father.balanceFactor = 0;
                father.left.balanceFactor = 0;
                return rightRotate(father);
            case -1:
                // 说明插入在了左孩子的右子树上，需要双旋处理
                // 先进行左旋，再进行右旋
                AVLNode leftRight = father.left.right;

                switch (leftRight.balanceFactor) {
                    case 0:
                        father.balanceFactor = 0;
                        father.left.balanceFactor = 0;
                        break;
                    case 1:
                        father.left.balanceFactor = 0;
                        father.balanceFactor = -1;
                        break;
                    case -1:
                        father.left.balanceFactor = 1;
                        father.balanceFactor = 0;
                        break;
                    default:
                        break;
                }
                leftRight.balanceFactor = 0;
                father.left = leftRotate(father.left);
                return rightRotate(father);
            default:
                return father;
        }
    }

    /**
     * balanceFactor为0时，左右子树高度一样
     * balanceFactor为1时，左子树比右子树高
     * balanceFactor为-1时，左子树比右子树矮
     *
     * @param father AVLNode
     */
    private AVLNode rightBalance(AVLNode father) {
        switch (father.right.balanceFactor) {
            case -1:
                // 说明插入在了右孩子的右子树上，需要进行左旋
                father.balanceFactor = 0;
                father.right.balanceFactor = 0;
                return leftRotate(father);
            case 1:
                // 说明插入在了右孩子的左子树上，需要双旋处理
                // 先进行右旋，再进行左旋
                AVLNode rightLeft = father.right.left;

                switch (rightLeft.balanceFactor) {
                    case 0:
                        father.balanceFactor = 0;
                        father.right.balanceFactor = 0;
                        break;
                    case 1:
                        father.right.balanceFactor = -1;
                        father.balanceFactor = 0;
                        break;
                    case -1:
                        father.right.balanceFactor = 0;
                        father.balanceFactor = 1;
                        break;
                    default:
                        break;
                }
                rightLeft.balanceFactor = 0;
                father.right = rightRotate(father.right);
                return leftRotate(father);
            default:
                return father;
        }
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    public AVLNode insert(AVLNode tree, int value) {
        // 如果树是空的（可以认为是root为空，或者左右叶节点为空）
        if (tree == null) {
            isTaller = true;
            return new AVLNode(value);
        }
        // 如果树不为空，但是插入的数值已经存在
        if (tree.value == value) {
            System.out.println("不能插入相同的数据");
            isTaller = false;
            return tree;
        }
        // 如果数据小于，则左子树插入
        if (value < tree.value) {
            tree.left = insert(tree.left, value);
            if (isTaller) {
                switch (tree.balanceFactor) {
                    // 原本左右树一样高，现在左树变高了
                    case 0:
                        isTaller = true;
                        tree.balanceFactor = 1;
                        return tree;
                    // 原本左树比右树高，现在需要进行平衡
                    case 1:
                        isTaller = false;
                        return leftBalance(tree);
                    // 原本左树比右树低，现在左右树相等了
                    case -1:
                        isTaller = false;
                        tree.balanceFactor = 0;
                        return tree;
                }
            }
        } else {
            // 如果数据大于，则右子树插入
            tree.right = insert(tree.right, value);
            if (isTaller) {
                switch (tree.balanceFactor) {
                    // 原本左右树一样高，现在右树变高了
                    case 0:
                        isTaller = true;
                        tree.balanceFactor = -1;
                        return tree;
                    // 原本左树比右树高，现在左右树相等了
                    case 1:
                        isTaller = false;
                        tree.balanceFactor = 0;
                        return tree;
                    // 原本左树比右树低，现在需要进行平衡
                    case -1:
                        isTaller = false;
                        return rightBalance(tree);
                }
            }
        }
        return tree;
    }

    void preOrder() {
        preOrderDisplay(root);
    }

    private void preOrderDisplay(AVLNode node) {
        if (node == null) {
            return;
        }
        System.out.print(node.value + " ");
        preOrderDisplay(node.left);
        preOrderDisplay(node.right);
    }

    void inOrder() {
        inOrderDisplay(root);
    }

    private void inOrderDisplay(AVLNode node) {
        if (node == null) {
            return;
        }
        inOrderDisplay(node.left);
        System.out.print(node.value + " ");
        inOrderDisplay(node.right);
    }
}

package com.khch.datastructure.tree.avl;

public class AVLTree {
    public static final int LEFT_HIGH = 1;
    public static final int EQUAL_HIGH = 0;
    public static final int RIGHT_HIGH = -1;

    private AVLNode root;

    public void insert(AVLNode avlNode) {
        if (root == null) {
            root = avlNode;
        }
    }

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
     * @param father
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
     * @param father
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
     * @param father
     */
    private void leftBalance(AVLNode father) {
        AVLNode needToRotateNode = father.left;

        // 说明插入在了左孩子的左子树上，需要进行右旋
        if (needToRotateNode.balanceFactor == 1) {
            father.balanceFactor = EQUAL_HIGH;
            needToRotateNode.balanceFactor = EQUAL_HIGH;
            rightRotate(father);
        }
        // 说明插入在了左孩子的右子树上，需要双旋处理
        // 先进行左旋，再进行右旋
        if (needToRotateNode.balanceFactor == RIGHT_HIGH) {
            AVLNode rightChild = needToRotateNode.right;

            switch (rightChild.balanceFactor) {
                case EQUAL_HIGH:
                    father.balanceFactor = EQUAL_HIGH;
                    needToRotateNode.balanceFactor = EQUAL_HIGH;
                    break;
                case LEFT_HIGH:
                    needToRotateNode.balanceFactor = EQUAL_HIGH;
                    father.balanceFactor = RIGHT_HIGH;
                    break;
                case RIGHT_HIGH:
                    needToRotateNode.balanceFactor = LEFT_HIGH;
                    father.balanceFactor = EQUAL_HIGH;
                    break;
                default:
                    break;
            }
            rightChild.balanceFactor = EQUAL_HIGH;
            father = leftRotate(father);
            father = rightRotate(father);
        }
    }

    /**
     * balanceFactor为0时，左右子树高度一样
     * balanceFactor为1时，左子树比右子树高
     * balanceFactor为-1时，左子树比右子树矮
     *
     * @param father
     */
    private void rightBalance(AVLNode father) {
        AVLNode needToRotateNode = father.right;

        // 说明插入在了右孩子的右子树上，需要进行左旋
        if (needToRotateNode.balanceFactor == RIGHT_HIGH) {
            father.balanceFactor = EQUAL_HIGH;
            needToRotateNode.balanceFactor = EQUAL_HIGH;
            leftRotate(father);
        }
        // 说明插入在了右孩子的左子树上，需要双旋处理
        // 先进行右旋，再进行左旋
        if (needToRotateNode.balanceFactor == LEFT_HIGH) {
            AVLNode leftChild = needToRotateNode.left;

            switch (leftChild.balanceFactor) {
                case EQUAL_HIGH:
                    father.balanceFactor = EQUAL_HIGH;
                    needToRotateNode.balanceFactor = EQUAL_HIGH;
                    break;
                case LEFT_HIGH:
                    needToRotateNode.balanceFactor = RIGHT_HIGH;
                    father.balanceFactor = EQUAL_HIGH;
                    break;
                case RIGHT_HIGH:
                    needToRotateNode.balanceFactor = EQUAL_HIGH;
                    father.balanceFactor = LEFT_HIGH;
                    break;
                default:
                    break;
            }
            leftChild.balanceFactor = EQUAL_HIGH;
            father = rightRotate(father);
            father = leftRotate(father);
        }
    }
}

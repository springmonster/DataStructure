package com.khch.datastructure.tree.avl;

public class AVLTree {
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
            father.balanceFactor = 0;
            needToRotateNode.balanceFactor = 0;
            rightRotate(father);
        }
        // 说明插入在了左孩子的右子树上，需要双旋处理
        // 先进行左旋，再进行右旋
        if (needToRotateNode.balanceFactor == -1) {
            AVLNode rightChild = needToRotateNode.right;

            switch (rightChild.balanceFactor) {
                case 0:
                    father.balanceFactor = 0;
                    needToRotateNode.balanceFactor = 0;
                    break;
                case 1:
                    needToRotateNode.balanceFactor = 0;
                    father.balanceFactor = -1;
                    break;
                case -1:
                    needToRotateNode.balanceFactor = 1;
                    father.balanceFactor = 0;
                    break;
                default:
                    break;
            }
            rightChild.balanceFactor = 0;
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
        if (needToRotateNode.balanceFactor == -1) {
            father.balanceFactor = 0;
            needToRotateNode.balanceFactor = 0;
            leftRotate(father);
        }
        // 说明插入在了右孩子的左子树上，需要双旋处理
        // 先进行右旋，再进行左旋
        if (needToRotateNode.balanceFactor == 1) {
            AVLNode leftChild = needToRotateNode.left;

            switch (leftChild.balanceFactor) {
                case 0:
                    father.balanceFactor = 0;
                    needToRotateNode.balanceFactor = 0;
                    break;
                case 1:
                    needToRotateNode.balanceFactor = 0;
                    father.balanceFactor = -1;
                    break;
                case -1:
                    needToRotateNode.balanceFactor = 1;
                    father.balanceFactor = 0;
                    break;
                default:
                    break;
            }
            leftChild.balanceFactor = 0;
            father = rightRotate(father);
            father = leftRotate(father);
        }
    }
}

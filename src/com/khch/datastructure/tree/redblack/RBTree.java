package com.khch.datastructure.tree.redblack;

/**
 * 不允许插入相同的数据
 */
public class RBTree {
    public RBNode root;

    public void insert(int value) {
        RBNode rbNode = new RBNode();
        rbNode.isRed = true;
        rbNode.value = value;

        RBNode currentParent = null;
        RBNode current = root;
        while (current != null) {
            currentParent = current;
            if (rbNode.compareTo(current) < 0) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        if (currentParent == null) {
            root = rbNode;
        } else {
            if (rbNode.compareTo(currentParent) < 0) {
                rbNode.parent = currentParent;
                currentParent.leftChild = rbNode;
            } else {
                rbNode.parent = currentParent;
                currentParent.rightChild = rbNode;
            }
        }

        insertFixUp(rbNode);
    }

    private void insertFixUp(RBNode rbNode) {
        RBNode parent, grandParent;
        parent = rbNode.parent;
        while (parent != null && parent.isRed) {
            grandParent = parent.parent;

            if (parent == grandParent.leftChild) {
                RBNode uncle = grandParent.rightChild;
                // 两个子节点都为红色
                if (uncle != null && uncle.isRed) {
                    uncle.isRed = false;
                    parent.isRed = false;
                    grandParent.isRed = true;
                    rbNode = grandParent;
                    parent = rbNode.parent;
                    continue;
                }
                // 为右子节点
                if (parent.rightChild == rbNode) {
                    llRotate(parent);
                    RBNode tmp = parent;
                    parent = rbNode;
                    rbNode = tmp;
                }
                // 为左子节点
                parent.isRed = false;
                grandParent.isRed = true;
                rrRotate(grandParent);
            } else {
                RBNode uncle = grandParent.leftChild;
                // 两个子节点都为红色
                if (uncle != null && uncle.isRed) {
                    uncle.isRed = false;
                    parent.isRed = false;
                    grandParent.isRed = true;
                    rbNode = grandParent;
                    parent = rbNode.parent;
                    continue;
                }
                // 为左子节点
                if (parent.leftChild == rbNode) {
                    rrRotate(parent);
                    RBNode tmp = parent;
                    parent = rbNode;
                    rbNode = tmp;
                }
                // 为右子节点
                parent.isRed = false;
                grandParent.isRed = true;
                llRotate(grandParent);
            }
        }

        root.isRed = false;
    }

    /*
     * 对红黑树的节点(x)进行左旋转
     *
     * 左旋示意图(对节点x进行左旋)：
     *      px                              px
     *     /                               /
     *    x                               y
     *   /  \      --(左旋)-.           / \                #
     *  lx   y                          x  ry
     *     /   \                       /  \
     *    ly   ry                     lx  ly
     *
     *
     */
    private void llRotate(RBNode x) {
        RBNode y = x.rightChild;
        x.rightChild = y.leftChild;
        if (y.leftChild != null) {
            y.leftChild.parent = x;
        }
        y.parent = x.parent;

        if (x.parent == null) {
            root = y;
        } else {
            if (x.parent.leftChild == x) {
                x.parent.leftChild = y;
            } else {
                x.parent.rightChild = y;
            }
        }
        y.leftChild = x;
        x.parent = y;
    }

    /*
     * 对红黑树的节点(y)进行右旋转
     *
     * 右旋示意图(对节点y进行左旋)：
     *            py                               py
     *           /                                /
     *          y                                x
     *         /  \      --(右旋)-.            /  \                     #
     *        x   ry                           lx   y
     *       / \                                   / \                   #
     *      lx  rx                                rx  ry
     *
     */
    private void rrRotate(RBNode y) {
        RBNode x = y.leftChild;
        y.leftChild = x.rightChild;
        if (x.rightChild != null) {
            x.rightChild.parent = y;
        }
        x.parent = y.parent;
        if (y.parent == null) {
            root = x;
        } else {
            if (y == y.parent.leftChild) {
                y.parent.leftChild = x;
            } else {
                y.parent.rightChild = x;
            }
        }
        x.rightChild = y;
        y.parent = x;
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

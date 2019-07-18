package com.khch.datastructure.tree.binarysearch;

public class BinarySearchTree {

    private BSTreeNode root;

    public void insert(int value) {
        BSTreeNode newNode = new BSTreeNode();
        newNode.value = value;

        if (root == null) {
            root = newNode;
        } else {
            BSTreeNode currentNode = root;
            BSTreeNode parentNode = currentNode;
            boolean isLeft = false;
            while (currentNode != null) {
                parentNode = currentNode;
                if (value < currentNode.value) {
                    currentNode = currentNode.leftChild;
                    isLeft = true;
                } else {
                    currentNode = currentNode.rightChild;
                    isLeft = false;
                }
            }
            if (isLeft) {
                parentNode.leftChild = newNode;
            } else {
                parentNode.rightChild = newNode;
            }
        }
    }

    /**
     * 1. 如果查找到的节点没有孩子
     * 2. 如果查找到的节点只有左孩子或者右孩子
     * 3. 如果查找到的节点左右孩子都存在
     *
     * @param value
     */
    public void delete(int value) {
        if (root == null) {
            return;
        }
        BSTreeNode needDeleteNode = null;
        BSTreeNode currentNode = root;
        BSTreeNode needDeleteNodeParent = root;
        boolean isLeft = false;
        while (currentNode != null) {
            if (value < currentNode.value) {
                needDeleteNodeParent = currentNode;
                currentNode = currentNode.leftChild;
                isLeft = true;
            } else if (value > currentNode.value) {
                needDeleteNodeParent = currentNode;
                currentNode = currentNode.rightChild;
                isLeft = false;
            } else {
                needDeleteNode = currentNode;
                break;
            }
        }
        // 如果needDeleteNode是null，那么根本没找到
        if (needDeleteNode != null) {
            // 如果没有左右孩子
            if (needDeleteNode.leftChild == null && needDeleteNode.rightChild == null) {
                if (isLeft) {
                    needDeleteNodeParent.leftChild = null;
                } else {
                    needDeleteNodeParent.rightChild = null;
                }
            }
            // 如果只有右孩子
            if (needDeleteNode.leftChild == null && needDeleteNode.rightChild != null) {
                if (isLeft) {
                    needDeleteNodeParent.leftChild = needDeleteNode.rightChild;
                } else {
                    needDeleteNodeParent.rightChild = needDeleteNode.rightChild;
                }
            }
            // 如果只有左孩子
            if (needDeleteNode.leftChild != null && needDeleteNode.rightChild == null) {
                if (isLeft) {
                    needDeleteNodeParent.leftChild = needDeleteNode.leftChild;
                } else {
                    needDeleteNodeParent.rightChild = needDeleteNode.leftChild;
                }
            }
            // 如果左右孩子都存在
            if (needDeleteNode.leftChild != null && needDeleteNode.rightChild != null) {
                deleteIfTwoChildrenExist(needDeleteNode, needDeleteNodeParent, isLeft);
            }
        }
    }

    public boolean find(int value) {
        if (root == null) {
            return false;
        }
        BSTreeNode currentNode = root;
        while (currentNode != null) {
            if (value < currentNode.value) {
                currentNode = currentNode.leftChild;
            } else if (value > currentNode.value) {
                currentNode = currentNode.rightChild;
            } else {
                return true;
            }
        }
        return false;
    }

    public void display() {
        if (root == null) {
            System.out.println("Tree is null");
        } else {
            System.out.println("------------前序遍历--------------");
            pre(root);
            System.out.println();
            System.out.println("------------前序遍历--------------");
//            System.out.println("------------中序遍历--------------");
//            mid(root);
//            System.out.println();
//            System.out.println("------------中序遍历--------------");
        }
    }

    private void pre(BSTreeNode bsTreeNode) {
        if (bsTreeNode == null) {
            return;
        } else {
            System.out.print(bsTreeNode.value + " ");
            pre(bsTreeNode.leftChild);
            pre(bsTreeNode.rightChild);
        }
    }

    private void mid(BSTreeNode bsTreeNode) {
        if (bsTreeNode == null) {
            return;
        } else {
            mid(bsTreeNode.leftChild);
            System.out.print(bsTreeNode.value + " ");
            mid(bsTreeNode.rightChild);
        }
    }

    private BSTreeNode deleteIfTwoChildrenExist(BSTreeNode needDeleteNode, BSTreeNode needDeleteNodeParent, boolean isLeft) {
        BSTreeNode currentNode = needDeleteNode;
        BSTreeNode currentNodeParent = needDeleteNode;
        BSTreeNode currentNodeParentParent = needDeleteNode;

        currentNode = currentNode.rightChild;
        if (currentNode.leftChild == null) {
            currentNode.leftChild = needDeleteNode.leftChild;
            if (isLeft) {
                needDeleteNodeParent.leftChild = currentNode;
            } else {
                needDeleteNodeParent.rightChild = currentNode;
            }
        } else {
            while (currentNode != null) {
                currentNodeParentParent = currentNodeParent;
                currentNodeParent = currentNode;
                currentNode = currentNode.leftChild;
            }

            currentNodeParentParent.leftChild = currentNodeParent.rightChild;
            currentNodeParent.leftChild = needDeleteNode.leftChild;
            currentNodeParent.rightChild = needDeleteNode.rightChild;
            if (needDeleteNode != root) {
                if (isLeft) {
                    needDeleteNodeParent.leftChild = currentNodeParent;
                } else {
                    needDeleteNodeParent.rightChild = currentNodeParent;
                }
            } else {
                root = currentNodeParent;
            }
        }
        return null;
    }
}
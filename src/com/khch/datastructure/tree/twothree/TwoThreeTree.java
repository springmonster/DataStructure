package com.khch.datastructure.tree.twothree;

/**
 * 假设插入不重复的数据
 */
public class TwoThreeTree {
    private TTNode root;

    public void insert(int value) throws Exception {
        // 这里分几种情况
        // 如果是2-结点，转换为3-结点
        // 如果是3-结点，转换为3个2-结点
        // 如果父节点是2-结点，插入的为3-结点
        // 如果父节点是3-结点，插入的为3-结点
        // 如果插入结点到根节点都是3-结点，则根节点变为临时的4结点，再分解
        TTNode insertedNode = findInsertedNode(value);
        insertNode(insertedNode, value, null, null);
    }

    /**
     * 只考虑插入的情况
     *
     * @param value
     * @return
     */
    private TTNode findInsertedNode(int value) throws Exception {
        TTNode currentNode = root;
        TTNode parentNode = currentNode;

        while (currentNode != null) {
            parentNode = currentNode;
            if (currentNode.isTwoNode()) {
                if (value < currentNode.values[0]) {
                    currentNode = currentNode.children[0];
                } else if (value > currentNode.values[0]) {
                    currentNode = currentNode.children[1];
                } else {
                    throw new Exception("同样的数据");
                }
            } else {
                if (value < currentNode.values[0]) {
                    currentNode = currentNode.children[0];
                } else if (value > currentNode.values[0] && value < currentNode.values[1]) {
                    currentNode = currentNode.children[1];
                } else if (value > currentNode.values[1]) {
                    currentNode = currentNode.children[2];
                } else {
                    throw new Exception("同样的数据");
                }
            }
        }

        return parentNode;
    }

    private void insertNode(TTNode insertedNode, int value, TTNode leftChild, TTNode rightChild) {
        if (insertedNode == null) {
            insertedNode = new TTNode();
            insertedNode.values[0] = value;
            root = insertedNode;

            insertedNode.children[0] = leftChild;
            insertedNode.children[1] = rightChild;
            if (leftChild != null) {
                leftChild.parentNode = insertedNode;
            }
            if (rightChild != null) {
                rightChild.parentNode = insertedNode;
            }
        } else {
            // 如果是2-结点，则直接插入
            if (insertedNode.isTwoNode()) {
                if (value > insertedNode.values[0]) {
                    insertedNode.values[1] = value;

                    insertedNode.children[1] = leftChild;
                    insertedNode.children[2] = rightChild;

                    if (leftChild != null) {
                        leftChild.parentNode = insertedNode;
                    }
                    if (rightChild != null) {
                        rightChild.parentNode = insertedNode;
                    }
                } else {
                    insertedNode.values[1] = insertedNode.values[0];
                    insertedNode.values[0] = value;

                    insertedNode.children[0] = leftChild;
                    insertedNode.children[1] = rightChild;

                    if (leftChild != null) {
                        leftChild.parentNode = insertedNode;
                    }
                    if (rightChild != null) {
                        rightChild.parentNode = insertedNode;
                    }
                }
            } else {
                // 如果是3-结点
                int min = insertedNode.values[0];
                int max = insertedNode.values[1];
                TTNode insertedNodeLeftChild = insertedNode.children[0];
                TTNode insertedNodeMidChild = insertedNode.children[1];
                TTNode insertedNodeRightChild = insertedNode.children[2];

                if (value < min) {
                    TTNode tmpLeftChild = new TTNode();
                    tmpLeftChild.values[0] = value;

                    TTNode tmpRightChild = new TTNode();
                    tmpRightChild.values[0] = max;

                    tmpLeftChild.children[0] = leftChild;
                    tmpLeftChild.children[1] = rightChild;
                    tmpRightChild.children[0] = insertedNodeMidChild;
                    tmpRightChild.children[1] = insertedNodeRightChild;

                    if (leftChild != null) {
                        leftChild.parentNode = tmpLeftChild;
                    }
                    if (rightChild != null) {
                        rightChild.parentNode = tmpLeftChild;
                    }

                    insertNode(insertedNode.parentNode, min, tmpLeftChild, tmpRightChild);
                } else if (value > min && value < max) {
                    TTNode tmpLeftChild = new TTNode();
                    tmpLeftChild.values[0] = min;

                    TTNode tmpRightChild = new TTNode();
                    tmpRightChild.values[0] = max;

                    tmpLeftChild.children[0] = insertedNodeLeftChild;
                    tmpLeftChild.children[1] = leftChild;
                    tmpRightChild.children[0] = rightChild;
                    tmpRightChild.children[1] = insertedNodeRightChild;

                    if (leftChild != null) {
                        leftChild.parentNode = tmpLeftChild;
                    }
                    if (rightChild != null) {
                        rightChild.parentNode = tmpRightChild;
                    }

                    insertNode(insertedNode.parentNode, value, tmpLeftChild, tmpRightChild);
                } else {
                    TTNode tmpLeftChild = new TTNode();
                    tmpLeftChild.values[0] = min;

                    TTNode tmpRightChild = new TTNode();
                    tmpRightChild.values[0] = value;

                    tmpLeftChild.children[0] = insertedNodeLeftChild;
                    tmpLeftChild.children[1] = insertedNodeMidChild;
                    tmpRightChild.children[0] = leftChild;
                    tmpRightChild.children[1] = rightChild;

                    if (leftChild != null) {
                        leftChild.parentNode = tmpRightChild;
                    }
                    if (rightChild != null) {
                        rightChild.parentNode = tmpRightChild;
                    }

                    insertNode(insertedNode.parentNode, max, tmpLeftChild, tmpRightChild);
                }
            }
        }
    }

    public void display() {
        if (root != null) {
            displayNode(root);
        } else {
            System.out.println("2-3树是空的");
        }
        System.out.println();
    }

    private void displayNode(TTNode ttNode) {
        if (ttNode != null) {
            if (ttNode.isTwoNode()) {
                System.out.print(ttNode.values[0] + " ");
            } else {
                System.out.print(ttNode.values[0] + " " + ttNode.values[1] + " ");
            }
            if (ttNode.isTwoNode()) {
                displayNode(ttNode.children[0]);
                displayNode(ttNode.children[1]);
            } else {
                displayNode(ttNode.children[0]);
                displayNode(ttNode.children[1]);
                displayNode(ttNode.children[2]);
            }
        }
    }
}

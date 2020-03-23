package com._2020.skiplist;

import java.util.Random;

public class SkipList {

    private SkipListNode head;
    private SkipListNode tail;
    private int size;
    private int maxLevels;
    private Random random;
    // 向上提升几率
    private static final double PROBABILITY = 0.5;
    private static final int HEAD_VALUE = Integer.MIN_VALUE;
    private static final int TAIL_VALUE = Integer.MAX_VALUE;

    public SkipList() {
        random = new Random();
        head = new SkipListNode(HEAD_VALUE);
        tail = new SkipListNode(TAIL_VALUE);
        head.right = tail;
        tail.left = head;
        size = 0;
        maxLevels = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void put(int value) {
        SkipListNode leftNodeOfInsertedNode = findLeftNodeOfInsertNode(value);

        SkipListNode insertedNode = new SkipListNode(value);
        insertNode(leftNodeOfInsertedNode, insertedNode);

        int currentLevel = 0;
        while (random.nextDouble() < PROBABILITY) {
            if (currentLevel >= maxLevels) {
                maxLevels++;
                SkipListNode headNode = new SkipListNode(HEAD_VALUE);
                SkipListNode tailNode = new SkipListNode(TAIL_VALUE);
                headNode.right = tailNode;
                tailNode.left = headNode;
                headNode.down = head;
                tailNode.down = tail;
                head.up = headNode;
                tail.up = tailNode;
                head = headNode;
                tail = tailNode;
            }

            //将p移动到上一层
            while (leftNodeOfInsertedNode.up == null) {
                leftNodeOfInsertedNode = leftNodeOfInsertedNode.left;
            }
            leftNodeOfInsertedNode = leftNodeOfInsertedNode.up;

            SkipListNode highLevelNode = new SkipListNode(value);
            //将highLevelNode插入到node的后面
            insertNode(leftNodeOfInsertedNode, highLevelNode);
            //将上层节点和下层节点上下连接
            highLevelNode.down = insertedNode;
            insertedNode.up = highLevelNode;
            insertedNode = highLevelNode;
            currentLevel++;
        }

        size++;
    }

    private SkipListNode findLeftNodeOfInsertNode(int value) {
        SkipListNode node = head;
        while (true) {
            while (node.right != null && node.right.value <= value) {
                node = node.right;
            }
            if (node.down != null) {
                node = node.down;
            } else {
                break;
            }
        }
        return node;
    }

    private void insertNode(SkipListNode leftNodeOfInsertedNode, SkipListNode insertedNode) {
        insertedNode.right = leftNodeOfInsertedNode.right;
        insertedNode.left = leftNodeOfInsertedNode;
        leftNodeOfInsertedNode.right.left = insertedNode;
        leftNodeOfInsertedNode.right = insertedNode;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "跳跃表为空！";
        }
        StringBuilder builder = new StringBuilder();
        SkipListNode p = head;
        while (p.down != null) {
            p = p.down;
        }

        while (p.right != null) {
            builder.append(p);
            builder.append("\n");
            p = p.right;
        }

        return builder.toString();
    }
}

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
        head.next = tail;
        tail.pre = head;
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
        SkipListNode node = findNode(value);

        if (value == node.value) {
            node.value = value;
            return;
        }

        SkipListNode newNode = new SkipListNode(value);
        insertNode(node, newNode);

        int currentLevel = 0;
        while (random.nextDouble() < PROBABILITY) {
            if (currentLevel >= maxLevels) {
                maxLevels++;
                SkipListNode headNode = new SkipListNode(HEAD_VALUE);
                SkipListNode tailNode = new SkipListNode(TAIL_VALUE);
                headNode.next = tailNode;
                tailNode.pre = headNode;
                headNode.down = head;
                tailNode.down = tail;
                head.up = headNode;
                tail.up = tailNode;
                head = headNode;
                tail = tailNode;
            }

            //将p移动到上一层
            while (node.up == null) {
                node = node.pre;
            }
            node = node.up;

            SkipListNode highLevelNode = new SkipListNode(value);//只保存key就ok
            insertNode(node, highLevelNode);//将highLevelNode插入到node的后面
            //将e和q上下连接
            highLevelNode.down = newNode;
            newNode.up = highLevelNode;
            newNode = highLevelNode;
            currentLevel++;
        }

        size++;
    }

    private SkipListNode findNode(int value) {
        SkipListNode node = head;
        while (true) {
            while (node.next != null && node.next.value <= value) {
                node = node.next;
            }
            if (node.down != null) {
                node = node.down;
            } else {
                break;
            }
        }
        return node;
    }

    private void insertNode(SkipListNode oldNode, SkipListNode newNode) {
        newNode.next = oldNode.next;
        newNode.pre = oldNode;
        oldNode.next.pre = newNode;
        oldNode.next = newNode;
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

        while (p.pre != null) {
            p = p.pre;
        }

        if (p.next != null) {
            p = p.next;
        }

        while (p.next != null) {
            builder.append(p);
            builder.append("\n");
            p = p.next;
        }

        return builder.toString();
    }
}

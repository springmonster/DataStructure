package com._2020.skiplist;

public class SkipListNode {
    public int value;
    public SkipListNode up;
    public SkipListNode down;
    public SkipListNode pre;
    public SkipListNode next;

    public SkipListNode(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SkipListNode{" +
                "value=" + value +
                '}';
    }
}

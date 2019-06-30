package com.khch.datastructure.stackqueue;

public class QueueX {
    int[] array;
    int head = 0;
    int tail = 0;
    int elementCount;

    public QueueX(int maxSize) {
        array = new int[maxSize];
    }

    public void insert(int value) {
        array[tail++] = value;
        elementCount++;
    }

    public int remove() {
        int result = array[head];
        array[head] = 0;
        head++;
        elementCount--;
        return result;
    }
}

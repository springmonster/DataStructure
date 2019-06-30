package com.khch.datastructure.stackqueue;

public class QueueXCircle {
    Object[] array;
    int head;
    int tail;
    int maxSize;

    public QueueXCircle(int maxSize) {
        array = new Object[maxSize];
        this.maxSize = maxSize;
    }

    public void insert(int value) {
        if ((tail + 1) % maxSize == head) {
            System.out.println("队列是满的");
            throw new IndexOutOfBoundsException();
        } else {
            tail = tail % maxSize;
            array[tail] = value;
            tail++;
        }
    }

    public Object remove() {
        if (head == tail) {
            System.out.println("队列是空的");
            throw new IndexOutOfBoundsException();
        } else {
            Object result = array[head];
            array[head] = null;
            head = (head + 1) % maxSize;
            return result;
        }
    }
}

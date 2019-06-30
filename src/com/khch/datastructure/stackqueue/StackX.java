package com.khch.datastructure.stackqueue;

public class StackX {
    private int[] array;
    private int top = -1;
    private int maxSize;

    public StackX(int maxSize) {
        array = new int[maxSize];
        this.maxSize = maxSize;
    }

    public void push(int value) {
        if (top < (maxSize - 1)) {
            array[++top] = value;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int pop() {
        if (top >= 0) {
            return array[top--];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public int peek() {
        if (top >= 0) {
            return array[top];
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == (maxSize - 1);
    }
}

package com._2020.tree.heap;

public class HeapTree {

    private final int[] array;
    private int size;
    private final int capacity;

    /**
     * 将0位作为保留，那么选择一个index，则左子节点是2*index，右子节点是2*index+1
     */
    public HeapTree(int max) {
        array = new int[max + 1];
        capacity = max + 1;
    }

    public void insert(int value) {
        if (size < capacity - 1) {
            size++;
            array[size] = value;
            swim(size);
        } else {
            throw new IndexOutOfBoundsException("超出容量");
        }
    }

    /**
     * 插入的时候进行向上调整
     */
    private void swim(int index) {
        int parentIndex = index / 2;
        while (parentIndex >= 1) {
            if (compare(array[parentIndex], array[index])) {
                swap(parentIndex, index);
            }
            index = parentIndex;
            parentIndex = index / 2;
        }
    }

    public int deleteMax() {
        array[capacity - 1] = array[1];
        array[1] = array[size];
        array[size] = 0;
        size--;

        sink();

        return array[capacity - 1];
    }

    /**
     * 删除的时候进行向下调整
     */
    private void sink() {
        int parentIndex = 1;
        int childIndex = parentIndex * 2;
        while (childIndex < size) {
            if (array[childIndex] > array[parentIndex]) {
                if (childIndex + 1 <= size && array[childIndex + 1] > array[childIndex]) {
                    swap(childIndex + 1, parentIndex);
                    parentIndex = childIndex + 1;
                } else {
                    swap(childIndex, parentIndex);
                    parentIndex = childIndex;
                }
                childIndex = parentIndex * 2;
            }
        }
    }

    /**
     * 需要做一个大顶堆
     *
     * @param a
     * @param b
     * @return
     */
    public boolean compare(int a, int b) {
        return a < b;
    }

    private void swap(int a, int b) {
        int temp = array[b];
        array[b] = array[a];
        array[a] = temp;
    }

    public void display() {
        for (int i = 0; i < array.length; i++) {
            System.out.println(" " + array[i]);
        }
    }
}

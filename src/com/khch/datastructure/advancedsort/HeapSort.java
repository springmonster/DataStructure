package com.khch.datastructure.advancedsort;

public class HeapSort {
    private static int[] array = new int[]{54, 26, 93, 17, 77, 31, 60, 55, 20};

    public static void main(String[] args) {
        // 1首先要构建一个堆
        // 2其次调整成最大堆
        // 3再将堆顶与对最后的数进行交换，使数组的长度减1，也就是堆中节点的数量减1
        // 4对于剩余的堆在进行2-3的操作直至堆中节点的数量为1
        heapSort();
        display();
    }

    private static void heapSort() {
        int length = array.length;
        while (length > 1) {
            buildHeap(length);
            swap(0, length - 1);
            length = length - 1;
        }
    }

    private static void buildHeap(int length) {
        for (int i = (length - 1) / 2; i >= 0; i--) {
            adjustHeap(i, length);
        }
    }

    private static void adjustHeap(int index, int length) {
        int maxIndex = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        if (leftChild < length && array[maxIndex] < array[leftChild]) {
            maxIndex = leftChild;
        }
        if (rightChild < length && array[maxIndex] < array[rightChild]) {
            maxIndex = rightChild;
        }
        if (maxIndex != index) {
            swap(index, maxIndex);
            // 这里需要注意，如果发生了交换，则还得需要进行父节点的比较，要将三个数或者两个数当中的最大值提取到父节点上
            adjustHeap(maxIndex, length);
        }
    }

    private static void swap(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void display() {
        for (int value : array) {
            System.out.print(value + " ");
        }
    }
}

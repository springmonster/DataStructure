package com._2020.sort;

/**
 * 首先是完全二叉树
 */
public class HeapSort2020_01 {
    private static final int[] array = new int[]{10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    //    private static int[] array = new int[]{54, 26, 93, 17, 77, 31, 60, 55, 20};
    private static int maxIndex = array.length - 1;

    public static void main(String[] args) {
        adjustHeap(maxIndex);

        heapSort(maxIndex);

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    private static void adjustHeap(int maxIndex) {
        for (int i = (maxIndex - 1) / 2; i >= 0; i--) {
            swapMaxValue(i, 2 * i + 1, 2 * i + 2);
        }
    }

    private static void heapSort(int index) {
        while (maxIndex >= 1) {
            swapTwoValues(0, maxIndex);
            maxIndex--;
            sink(0);
        }
    }

    private static void swapMaxValue(int parentIndex, int leftIndex, int rightIndex) {
        if (array[parentIndex] < array[leftIndex]) {
            if (array[leftIndex] < array[rightIndex]) {
                swapTwoValues(parentIndex, rightIndex);
                sink(rightIndex);
            } else {
                swapTwoValues(parentIndex, leftIndex);
                sink(leftIndex);
            }
        } else if (array[parentIndex] < array[rightIndex]) {
            swapTwoValues(parentIndex, rightIndex);
            sink(rightIndex);
        }
    }

    private static void swapTwoValues(int a, int b) {
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    private static void sink(int parentIndex) {
        int leftIndex = parentIndex * 2 + 1;
        int rightIndex = parentIndex * 2 + 2;

        if (rightIndex <= maxIndex) {
            if (array[parentIndex] < array[leftIndex]) {
                if (array[leftIndex] < array[rightIndex]) {
                    swapTwoValues(parentIndex, rightIndex);
                    sink(rightIndex);
                } else {
                    swapTwoValues(parentIndex, leftIndex);
                    sink(leftIndex);
                }
            } else {
                if (array[parentIndex] < array[rightIndex]) {
                    swapTwoValues(parentIndex, rightIndex);
                    sink(rightIndex);
                }
            }
        } else if (leftIndex <= maxIndex) {
            if (array[parentIndex] < array[leftIndex]) {
                swapTwoValues(parentIndex, leftIndex);
                sink(rightIndex);
            }
        }
    }
}

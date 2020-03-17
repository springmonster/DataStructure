package com._2020.sort;

/**
 * 有些问题
 */
public class HeapSort2020 {
    //    private static int[] array = new int[]{10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static int[] array = new int[]{54, 26, 93, 17, 77, 31, 60, 55, 20};
    private static int maxIndex = array.length - 1;

    public static void main(String[] args) {
        adjustHeap(maxIndex);

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    private static void adjustHeap(int maxIndex) {
        while (maxIndex > 0) {
            heapSort(maxIndex);

            int temp = array[maxIndex];
            array[maxIndex] = array[0];
            array[0] = temp;

            maxIndex = maxIndex - 1;

            adjustHeap(maxIndex);
        }
    }

    private static void heapSort(int index) {
        while (index >= 1) {
            int fatherIndex = (index - 1) / 2;

            if (array[fatherIndex] < array[index]) {
                int temp = array[index];
                array[index] = array[fatherIndex];
                array[fatherIndex] = temp;
            }

            index = index - 1;
        }
    }
}

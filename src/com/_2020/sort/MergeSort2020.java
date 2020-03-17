package com._2020.sort;

public class MergeSort2020 {
    private static int[] array = new int[]{5435, 574, 24234, 123, 54, 98, 4, 5608, 194, 5756};
    //    private static int[] array = new int[]{11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    private static int[] resultArray = new int[array.length];

    public static void main(String[] args) {
        mergeSort(0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    private static void mergeSort(int low, int high) {
        if (low < high) {
            int middle = (low + high) / 2;
            mergeSort(low, middle);
            mergeSort(middle + 1, high);

            fillResultArray(low, middle, high, low);
        }
    }

    private static void fillResultArray(int low, int middle, int high, int resultIndex) {
        int index1 = low;
        int index2 = middle + 1;

        while (index1 <= middle && index2 <= high) {
            if (array[index1] <= array[index2]) {
                resultArray[resultIndex++] = array[index1++];
            } else {
                resultArray[resultIndex++] = array[index2++];
            }
        }

        while (index1 <= middle) {
            resultArray[resultIndex++] = array[index1++];
        }

        while (index2 <= high) {
            resultArray[resultIndex++] = array[index2++];
        }

        while (low <= high) {
            array[low] = resultArray[low];
            low++;
        }
    }
}

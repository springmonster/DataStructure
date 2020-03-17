package com._2020.sort;

public class QuickSort2020 {
    private static int[] array = new int[]{10, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        quickSort(0, array.length - 1);
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
        }
    }

    private static void quickSort(int low, int high) {
        if (low < high) {
            int flag = findFlag(low, high);
            quickSort(low, flag - 1);
            quickSort(flag + 1, high);
        }
    }

    private static int findFlag(int low, int high) {
        int compareValue = array[low];
        int index = low;

        while (low < high) {
            while (low < high && compareValue <= array[high]) {
                high--;
            }

            int temp = array[high];
            array[high] = compareValue;
            array[index] = temp;
            index = high;

            while (low < high && compareValue >= array[low]) {
                low++;
            }

            int temp1 = array[low];
            array[low] = compareValue;
            array[index] = temp1;
            index = low;
        }

        return index;
    }
}

package com.khch.datastructure.recursion;

public class MergeSort {
    //    private static int[] array = new int[]{6, 5, 7, 4, 8, 3, 9, 2, 10, 1};
    private static int[] array = new int[]{5435, 574, 24234, 123, 54, 98, 4, 5608, 194, 5756};

    public static void main(String[] args) {
        divide(0, array.length - 1);
        display();
    }

    private static void divide(int low, int high) {
        if (low >= high) {
            return;
        } else {
            int mid = (low + high) / 2;
            divide(low, mid);
            divide(mid + 1, high);
            merge(low, mid, high);
        }
    }

    private static void merge(int low, int mid, int high) {
        int left = low;
        int right = mid + 1;
        int resultIndex = 0;

        int[] resultArray = new int[high - low + 1];

        while (left <= mid && right <= high) {
            if (array[left] < array[right]) {
                resultArray[resultIndex++] = array[left++];
            } else {
                resultArray[resultIndex++] = array[right++];
            }
        }
        while (left <= mid) {
            resultArray[resultIndex++] = array[left++];
        }
        while (right <= high) {
            resultArray[resultIndex++] = array[right++];
        }

        for (int item : resultArray) {
            array[low++] = item;
        }
    }

    private static void display() {
        for (int item : array) {
            System.out.print(item + " ");
        }
    }
}

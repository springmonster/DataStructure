package com.khch.datastructure.simplesort;

public class InsertionSort {
    private static int[] array = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {
        insertionSort();
        display();
    }

    private static void insertionSort() {
        for (int out = 1; out < array.length; out++) {
            int temp = array[out];
            int index = out;
            while (index > 0 && array[index - 1] > temp) {
                array[index] = array[index - 1];
                index--;
            }
            if (out != index) {
                array[index] = temp;
            }
        }
    }

    private static void display() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

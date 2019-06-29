package com.khch.datastructure.simplesort;

public class SelectionSort {
    private static int[] array = new int[]{6, 5, 7, 4, 8, 3, 9, 2, 10, 1};

    public static void main(String[] args) {
        selectionSort();
        display();
    }

    private static void selectionSort() {
//        for (int out = array.length - 1; out >= 1; out--) {
//            int max = array[0];
//            int maxIndex = 0;
//
//            for (int in = 1; in <= out; in++) {
//                if (array[in] > max) {
//                    max = array[in];
//                    maxIndex = in;
//                }
//            }
//
//            int temp = array[maxIndex];
//            array[maxIndex] = array[out];
//            array[out] = temp;
//        }

        for (int out = 0; out < array.length - 1; out++) {
            int min = out;
            for (int in = out + 1; in < array.length; in++) {
                if (array[in] < array[min]) {
                    min = in;
                }
            }
            int temp = array[min];
            array[min] = array[out];
            array[out] = temp;
        }
    }

    private static void display() {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }
}

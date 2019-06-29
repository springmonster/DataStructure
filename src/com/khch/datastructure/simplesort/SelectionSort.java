package com.khch.datastructure.simplesort;

public class SelectionSort {
    private static int[] array = new int[]{6, 5, 7, 4, 8, 3, 9, 2, 10, 1};

    public static void main(String[] args) {
        selectionSort();
        display();
    }

    private static void selectionSort() {
//        for (int out = innerArray.length - 1; out >= 1; out--) {
//            int max = innerArray[0];
//            int maxIndex = 0;
//
//            for (int in = 1; in <= out; in++) {
//                if (innerArray[in] > max) {
//                    max = innerArray[in];
//                    maxIndex = in;
//                }
//            }
//
//            int temp = innerArray[maxIndex];
//            innerArray[maxIndex] = innerArray[out];
//            innerArray[out] = temp;
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
